package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Koneksi {
    // Siapkan variabel untuk konfigurasi database
    private static final String URL = "jdbc:mysql://localhost:3306/Simaksi_Gunung";
    private static final String USER = "root"; // username default xampp
    private static final String PASSWORD = ""; // password default xampp (kosong)
    
    public static Connection getConnection() {
        Connection koneksi = null;
        try {
            // Registrasi driver (Opsional pada versi Java modern, tapi aman untuk ditulis)
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            
            // Membuat koneksi
            koneksi = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Koneksi Berhasil!"); 
        } catch (ClassNotFoundException e) {
            System.err.println("Driver tidak ditemukan: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Koneksi Gagal: " + e.getMessage());
        }
        return koneksi;
    }
    
    // Main method untuk ngetes langsung jalannya koneksi
    public static void main(String[] args) {
        getConnection();
    }
}