package controller;

import config.Koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Booking;

public class PemesananController {

    private Connection koneksiDB;

    public PemesananController() {
        this.koneksiDB = Koneksi.getInstance().getKoneksi();
    }

    /**
     * PERBAIKAN: Parameter menerima objek Booking, String gunung, dan String jalur
     * agar sesuai dengan pemanggilan dari form Pemesanan.
     */
    public boolean simpanBooking(Booking b, String gunung, String jalur) {
        String sql = "INSERT INTO booking (tanggal_naik, tanggal_turun, status_booking) VALUES (?, ?, ?)";
        try (PreparedStatement ps = koneksiDB.prepareStatement(sql)) {
            if (b.getTanggalNaik() != null) {
                ps.setDate(1, new java.sql.Date(b.getTanggalNaik().getTime()));
            } else {
                ps.setNull(1, java.sql.Types.DATE);
            }
            
            if (b.getTanggalTurun() != null) {
                ps.setDate(2, new java.sql.Date(b.getTanggalTurun().getTime()));
            } else {
                ps.setNull(2, java.sql.Types.DATE);
            }
            
            ps.setString(3, b.getStatusBooking());
            
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /** Mengembalikan sisa kuota untuk jalur dengan id tertentu. */
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
        String sql = "UPDATE booking SET status_booking = 'Lunas' WHERE id_booking = ?";
        try (PreparedStatement ps = koneksiDB.prepareStatement(sql)) {
            ps.setInt(1, idBooking);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}