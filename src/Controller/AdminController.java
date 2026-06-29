package controller;

import config.Koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class AdminController {

    private Connection koneksiDB;

    public AdminController() {
        this.koneksiDB = Koneksi.getInstance().getKoneksi();
    }

    public void tampilkanPendaftaranPending(JTable table) {
        String[] kolom = {"ID Pendaki", "Nama", "NIK", "Status"};
        DefaultTableModel model = new DefaultTableModel(kolom, 0);
        String sql = "SELECT pd.id_pendaki, u.nama, pd.nik, "
                + "COALESCE(pd.status_verifikasi,'Menunggu') AS status "
                + "FROM pendaki pd JOIN users u ON pd.id_user = u.id_user";
        try (PreparedStatement ps = koneksiDB.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                model.addRow(new Object[]{rs.getInt("id_pendaki"), rs.getString("nama"),
                        rs.getString("nik"), rs.getString("status")});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        table.setModel(model);
    }

    public void tampilkanPembayaranPending(JTable table) {
        String[] kolom = {"ID Booking", "Pendaki", "Total Biaya", "Status"};
        DefaultTableModel model = new DefaultTableModel(kolom, 0);
        String sql = "SELECT b.id_booking, u.nama, b.total_biaya, b.status_booking "
                + "FROM booking b JOIN pendaki pd ON b.id_pendaki = pd.id_pendaki "
                + "JOIN users u ON pd.id_user = u.id_user "
                + "WHERE b.status_booking = 'Menunggu Verifikasi'";
        try (PreparedStatement ps = koneksiDB.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                model.addRow(new Object[]{rs.getInt("id_booking"), rs.getString("nama"),
                        rs.getDouble("total_biaya"), rs.getString("status_booking")});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        table.setModel(model);
    }

    public boolean tambahJalur(String namaJalur, int idGunung, String deskripsi) {
        String sql = "INSERT INTO jalur_pendakian (nama_jalur, status_jalur, id_gunung, deskripsi_jalur) "
                + "VALUES (?, 'Aktif', ?, ?)";
        try (PreparedStatement ps = koneksiDB.prepareStatement(sql)) {
            ps.setString(1, namaJalur);
            ps.setInt(2, idGunung);
            ps.setString(3, deskripsi);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
