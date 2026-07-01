package controller;

import config.Koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement; 
import model.Booking;

public class PemesananController {

    private Connection koneksiDB;

    public PemesananController() {
        this.koneksiDB = Koneksi.getInstance().getKoneksi();
    }

    public String tambahBooking(Booking booking) {
        String sql = "INSERT INTO booking (id_pendaki, id_gunung, id_jalur, tanggal_naik, tanggal_turun, total_biaya, status_pembayaran) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = koneksiDB.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            ps.setInt(1, booking.getId_pendaki()); 
            ps.setInt(2, booking.getId_gunung());
            ps.setInt(3, booking.getId_jalur());
            ps.setString(4, booking.getTanggal_naik());
            ps.setString(5, booking.getTanggal_turun());
            ps.setInt(6, booking.getTotal_biaya());
            ps.setString(7, booking.getStatus_pembayaran());
            
            int rows = ps.executeUpdate();
            if (rows > 0) {
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    return String.valueOf(rs.getInt(1)); // Mengembalikan ID booking yang sukses dibuat
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int cekKuotaJalur(int idJalur) {
        String sql = "SELECT kuota_tersisa FROM jalur_pendakian WHERE id_jalur = ?";
        try (PreparedStatement ps = koneksiDB.prepareStatement(sql)) {
            ps.setInt(1, idJalur);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("kuota_tersisa");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public boolean verifikasiPembayaran(int idBooking) {
        String sql = "UPDATE booking SET status_pembayaran = 'Lunas' WHERE id_booking = ?";
        try (PreparedStatement ps = koneksiDB.prepareStatement(sql)) {
            ps.setInt(1, idBooking);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}