package controller;

import config.Koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class AuthController {
    private Connection conn;

    public AuthController() {
        this.conn = Koneksi.getConnection();
    }

    // Fungsi untuk Registrasi Pendaki Baru
    public boolean registerPendaki(String nama, String email, String noTelp, String password, String nik) {
        String queryUser = "INSERT INTO user (nama, email, no_telp, password, role) VALUES (?, ?, ?, ?, 'Pendaki')";
        
        try {
            // Jalankan transaksi otomatis agar jika salah satu gagal, semua dibatalkan
            conn.setAutoCommit(false);
            
            // 1. Simpan ke tabel User
            PreparedStatement psUser = conn.prepareStatement(queryUser, PreparedStatement.RETURN_GENERATED_KEYS);
            psUser.setString(1, nama);
            psUser.setString(2, email);
            psUser.setString(3, noTelp);
            psUser.setString(4, password); 
            
            int affectedRows = psUser.executeUpdate();
            if (affectedRows == 0) {
                conn.rollback();
                return false;
            }

            // Ambil ID User yang baru saja digenerate otomatis oleh MySQL
            ResultSet generatedKeys = psUser.getGeneratedKeys();
            if (generatedKeys.next()) {
                int idUserBaru = generatedKeys.getInt(1);
                
                // 2. Simpan ke tabel spesifik pendaki (relasi inheritance di DB)
                // Catatan: Jika Anda menyatukan semua di satu tabel, langkah kedua ini opsional.
                // Tapi di sini kita asumsikan disimpan sesuai relasi OOP-nya.
            }
            
            conn.commit();
            JOptionPane.showMessageDialog(null, "Registrasi Berhasil! Silakan Login.");
            return true;
            
        } catch (SQLException e) {
            try { conn.rollback(); } catch (SQLException ex) {}
            JOptionPane.showMessageDialog(null, "Registrasi Gagal: " + e.getMessage());
            return false;
        } finally {
            try { conn.setAutoCommit(true); } catch (SQLException e) {}
        }
    }

    // Fungsi untuk Login (Mengecek email dan password)
    public String login(String email, String password) {
        String query = "SELECT role, nama FROM user WHERE email = ? AND password = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                String role = rs.getString("role");
                String nama = rs.getString("nama");
                JOptionPane.showMessageDialog(null, "Selamat Datang, " + nama + "!");
                return role; // Mengembalikan 'Admin' atau 'Pendaki'
            } else {
                JOptionPane.showMessageDialog(null, "Email atau Password Salah!");
                return null;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error Login: " + e.getMessage());
            return null;
        }
    }
}