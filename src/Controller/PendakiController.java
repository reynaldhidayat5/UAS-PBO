package controller;

import config.Koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Pendaki;

public class PendakiController {

    private Connection koneksiDB;

    public PendakiController() {
        this.koneksiDB = Koneksi.getInstance().getKoneksi();
    }

   
    public boolean updatePendaki(Pendaki p) {
        String sql = "UPDATE pendaki SET nik=?, foto_ktp=?, alamat=?, kontak_darurat=?, jenis_kelamin=? "
                + "WHERE id_pendaki=?";
        try (PreparedStatement ps = koneksiDB.prepareStatement(sql)) {
            ps.setString(1, p.getNik());
            ps.setString(2, p.getFotoKTP());
            ps.setString(3, p.getAlamat());
            ps.setString(4, p.getKDarurat());
            ps.setString(5, p.getJKel());
            ps.setInt(6, p.getIdPendaki());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

   
    public boolean verifikasiPendaftaran(int idPendaki) {
        String sql = "UPDATE pendaki SET status_verifikasi = 'Terverifikasi' WHERE id_pendaki = ?";
        try (PreparedStatement ps = koneksiDB.prepareStatement(sql)) {
            ps.setInt(1, idPendaki);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
