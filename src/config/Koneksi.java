package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * Class untuk mengelola koneksi ke database MySQL.
 * Sesuaikan HOST, DB_NAME, USER, PASSWORD dengan konfigurasi MySQL anda.
 */
public class Koneksi {

    private static final String HOST = "localhost";
    private static final String PORT = "3306";
    private static final String DB_NAME = "db_simaksi";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    private static final String URL = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DB_NAME
            + "?useSSL=false&serverTimezone=Asia/Jakarta";

    private Connection koneksi;
    private static Koneksi instance;

    private Koneksi() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            koneksi = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null,
                    "Gagal terhubung ke database:\n" + e.getMessage(),
                    "Koneksi Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /** Singleton agar koneksi tidak dibuat berulang-ulang. */
    public static Koneksi getInstance() {
        if (instance == null) {
            instance = new Koneksi();
        }
        return instance;
    }

    public Connection getKoneksi() {
        try {
            if (koneksi == null || koneksi.isClosed()) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                koneksi = DriverManager.getConnection(URL, USER, PASSWORD);
            }
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null,
                    "Gagal terhubung ke database:\n" + e.getMessage(),
                    "Koneksi Error", JOptionPane.ERROR_MESSAGE);
        }
        return koneksi;
    }
}
