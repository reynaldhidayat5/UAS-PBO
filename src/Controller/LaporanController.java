package controller;

import config.Koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Laporan;
import model.Aduan_dan_Kritik_Saran;

public class LaporanController {

    private Connection koneksiDB;

    public LaporanController() {
        this.koneksiDB = Koneksi.getInstance().getKoneksi();
    }

    public void tampilkanLaporan(JTable table) {
        new Laporan().tampilkanKeTabel(table);
    }

    public boolean kirimAduan(Aduan_dan_Kritik_Saran r) {
        return r.simpanAduan();
    }

    public void tampilkanKritikSaran(JTable table) {
        String[] kolom = {"ID", "Tipe", "Isi Pesan", "ID Pendaki"};
        DefaultTableModel model = new DefaultTableModel(kolom, 0);
        String sql = "SELECT * FROM report ORDER BY id_report DESC";
        try (PreparedStatement ps = koneksiDB.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                model.addRow(new Object[]{rs.getInt("id_report"), rs.getString("tipe_aduan"),
                        rs.getString("isi_pesan"), rs.getInt("id_pendaki")});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        table.setModel(model);
    }
}
