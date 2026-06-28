package controller;

import config.Koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JOptionPane;

public class PemesananController {
    private Connection koneksi;

    public PemesananController() {
        this.koneksi = Koneksi.getConnection();
    }

    // Mengikuti diagram: Menyimpan data berdasarkan tanggal tanpa jumlah pengikut
    public boolean simpanBooking(String namaGunung, String namaJalur, Date tanggalNaik, Date tanggalTurun) {
        String sql = "INSERT INTO booking (id_user, id_gunung, id_jalur, tanggal_naik, tanggal_turun, status_booking) " +
                     "VALUES (1, (SELECT id_gunung FROM gunung WHERE nama_gunung = ?), " +
                     "(SELECT id_jalur FROM jalur_pendaki WHERE nama_jalur = ?), ?, ?, 'Pending')";
        try {
            PreparedStatement ps = koneksi.prepareStatement(sql);
            ps.setString(1, namaGunung);
            ps.setString(2, namaJalur);
            ps.setDate(3, new java.sql.Date(tanggalNaik.getTime()));
            ps.setDate(4, new java.sql.Date(tanggalTurun.getTime()));
            
            int rows = ps.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error Simpan Booking: " + e.getMessage());
            return false;
        }
    }

    // Fungsi simulasi hitung biaya murni berdasarkan selisih hari
    public double hitungTotalBiaya(Date naik, Date turun) {
        long diff = turun.getTime() - naik.getTime();
        long days = diff / (1000 * 60 * 60 * 24);
        if (days <= 0) days = 1;
        
        double tarifPerHari = 50000; 
        return days * tarifPerHari;
    }
}