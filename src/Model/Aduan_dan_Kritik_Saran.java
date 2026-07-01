package model;

import config.Koneksi;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Class "Aduan dan Kritik_Saran" pada diagram.
 */
public class Aduan_dan_Kritik_Saran {

    private int idReport;
    private String tipeAduan; 
    private String isiPesan;
    private int idPendaki;

    public Aduan_dan_Kritik_Saran() {
    }

    public Aduan_dan_Kritik_Saran(int idReport, String tipeAduan, String isiPesan, int idPendaki) {
        this.idReport = idReport;
        this.tipeAduan = tipeAduan;
        this.isiPesan = isiPesan;
        this.idPendaki = idPendaki;
    }

    public boolean simpanAduan() {
        String sql = "INSERT INTO report (tipe_aduan, isi_pesan, id_pendaki) VALUES (?, ?, ?)";
        try (PreparedStatement ps = Koneksi.getInstance().getKoneksi().prepareStatement(sql)) {
            ps.setString(1, tipeAduan);
            ps.setString(2, isiPesan);
            ps.setInt(3, idPendaki);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public int getIdReport() {
        return idReport;
    }

    public void setIdReport(int idReport) {
        this.idReport = idReport;
    }

    public String getTipeAduan() {
        return tipeAduan;
    }

    public void setTipeAduan(String tipeAduan) {
        this.tipeAduan = tipeAduan;
    }

    public String getIsiPesan() {
        return isiPesan;
    }

    public void setIsiPesan(String isiPesan) {
        this.isiPesan = isiPesan;
    }

    public int getIdPendaki() {
        return idPendaki;
    }

    public void setIdPendaki(int idPendaki) {
        this.idPendaki = idPendaki;
    }
}
