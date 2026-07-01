package controller;

import config.Koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Admin;
import model.Pendaki;
import model.User;

public class AuthController {

    private Connection koneksiDB;

    public AuthController() {
        this.koneksiDB = Koneksi.getInstance().getKoneksi();
    }

    /**
     * Login user (admin atau pendaki) berdasarkan email & password.
     * Mengembalikan object User (Admin/Pendaki) bila berhasil, null bila gagal.
     */
    public User loginUser(String email, String password) {
        String sql = "SELECT * FROM users WHERE email = ? AND password = ?";
        try (PreparedStatement ps = koneksiDB.prepareStatement(sql)) {
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int idUser = rs.getInt("id_user");
                String nama = rs.getString("nama");
                String noHp = rs.getString("no_hp");
                String role = rs.getString("role");

                if ("admin".equalsIgnoreCase(role)) {
                    return ambilAdmin(idUser, nama, email, noHp, password);
                } else {
                    return ambilPendaki(idUser, nama, email, noHp, password);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Admin ambilAdmin(int idUser, String nama, String email, String noHp, String password) {
    String sql = "SELECT * FROM admin WHERE id_user = ?";
    try (PreparedStatement ps = koneksiDB.prepareStatement(sql)) {
        ps.setInt(1, idUser);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            Admin a = new Admin(rs.getInt("id_admin"), idUser, rs.getString("shift_kerja"));
            a.setNama(nama);
            a.setEmail(email);
            a.setNoHp(noHp);
            a.setPassword(password);
            
            // 👇 TAMBAHKAN BARIS INI
            a.setRole("admin"); 
            
            return a;
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return null;
}

private Pendaki ambilPendaki(int idUser, String nama, String email, String noHp, String password) {
    String sql = "SELECT * FROM pendaki WHERE id_user = ?";
    try (PreparedStatement ps = koneksiDB.prepareStatement(sql)) {
        ps.setInt(1, idUser);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            // SINKRONKAN: Panggil constructor 10 parameter sesuai yang ada di Pendaki.java kamu
            Pendaki p = new Pendaki(
                rs.getInt("id_pendaki"),        
                nama,                           
                email,                          
                noHp,                          
                password,                     
                rs.getString("nik"),          
                rs.getString("foto_ktp"),      
                rs.getString("alamat"),        
                rs.getString("kontak_darurat"),  
                rs.getString("jenis_kelamin")   
            );
            
            p.setRole("pendaki"); 
            return p;
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return null;
}

    /** * PERBAIKAN: Mengubah tipe parameter pertama menjadi String nama 
     * agar sesuai dengan pengiriman data String dari View Registrasi.
     */
    public boolean registerPendaki(String nama, String email, String noTelp, String password, String nik) {
        String sqlUser = "INSERT INTO users (nama, email, no_hp, password, role) VALUES (?,?,?,?,'pendaki')";
        try (PreparedStatement ps = koneksiDB.prepareStatement(sqlUser, PreparedStatement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, nama);
            ps.setString(2, email);
            ps.setString(3, noTelp);
            ps.setString(4, password);
            int rows = ps.executeUpdate();
            if (rows == 0) {
                return false;
            }
            ResultSet rsKey = ps.getGeneratedKeys();
            int idUser = 0;
            if (rsKey.next()) {
                idUser = rsKey.getInt(1);
            }

            // Atribut opsional/lainnya diisi default kosong (null/"") terlebih dahulu agar pendaftaran awal sukses
            String sqlPendaki = "INSERT INTO pendaki (id_user, nik, foto_ktp, alamat, kontak_darurat, jenis_kelamin) "
                    + "VALUES (?,?,?,?,null,null)";
            try (PreparedStatement ps2 = koneksiDB.prepareStatement(sqlPendaki)) {
                ps2.setInt(1, idUser);
                ps2.setString(2, nik);
                ps2.setString(3, ""); // Default foto_ktp kosong
                ps2.setString(4, ""); // Default alamat kosong
                return ps2.executeUpdate() > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public String login(String email, String password) {
        String sql = "SELECT role FROM users WHERE email = ? AND password = ?";
        try (PreparedStatement ps = koneksiDB.prepareStatement(sql)) {
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            
            // Jika data email dan password ditemukan di database
            if (rs.next()) {
                return rs.getString("role"); // Kembalikan rolenya (Admin / Pendaki)
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        // Jika email/password salah atau tidak ditemukan, kembalikan null
        return null; 
    }
}