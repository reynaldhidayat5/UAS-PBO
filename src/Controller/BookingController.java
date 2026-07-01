package controller;

import config.Koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Booking;
import model.Gunung;
import model.Jalur_Pendakian;

public class BookingController {

    private Connection koneksiDB;

    public BookingController() {
        this.koneksiDB = Koneksi.getInstance().getKoneksi();
    }

    public void loadGunung(JComboBox combo) {
        DefaultComboBoxModel<Gunung> model = new DefaultComboBoxModel<>();
        String sql = "SELECT * FROM gunung";
        try (PreparedStatement ps = koneksiDB.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                model.addElement(new Gunung(rs.getInt("id_gunung"), rs.getString("nama_gunung"),
                        rs.getString("lokasi"), rs.getInt("kuota")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        combo.setModel(model);
    }

    public void loadJalurByGunung(int idGunung, JComboBox combo) {
        DefaultComboBoxModel<Jalur_Pendakian> model = new DefaultComboBoxModel<>();
        String sql = "SELECT * FROM jalur_pendakian WHERE id_gunung = ?";
        try (PreparedStatement ps = koneksiDB.prepareStatement(sql)) {
            ps.setInt(1, idGunung);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                model.addElement(new Jalur_Pendakian(rs.getInt("id_jalur"), rs.getString("nama_jalur"),
                        rs.getString("status_jalur"), idGunung, rs.getString("deskripsi_jalur"),
                        rs.getString("foto_estimasi_waktu")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        combo.setModel(model);
    }

    public void tampilkanKuotaJadwal(int idGunung, JTable table) {
        String[] kolom = {"Jalur", "Status", "Sisa Kuota"};
        DefaultTableModel model = new DefaultTableModel(kolom, 0);
        String sql = "SELECT id_jalur, nama_jalur, status_jalur FROM jalur_pendakian WHERE id_gunung = ?";
        try (PreparedStatement ps = koneksiDB.prepareStatement(sql)) {
            ps.setInt(1, idGunung);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int sisa = Booking.cekKuotaTersisa(rs.getInt("id_jalur"), idGunung);
                model.addRow(new Object[]{rs.getString("nama_jalur"), rs.getString("status_jalur"), sisa});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        table.setModel(model);
    }

    public model.Promo cekPromoDatabase(String kodePromo) {
        
        String sql = "SELECT * FROM promo WHERE kode_promo = ?";
        try (PreparedStatement ps = koneksiDB.prepareStatement(sql)) {
            ps.setString(1, kodePromo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                
                model.Promo promo = new model.Promo();
                promo.setKodePromo(rs.getString("kode_promo"));
                promo.setDiskon(rs.getDouble("diskon")); 
                return promo;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; 
    }

    
}