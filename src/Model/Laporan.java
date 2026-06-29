package model;

import config.Koneksi;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Laporan {

    private int idLaporan;
    private String jenisLaporan;

    public Laporan() {
    }

    public Laporan(int idLaporan, String jenisLaporan) {
        this.idLaporan = idLaporan;
        this.jenisLaporan = jenisLaporan;
    }

    /** Mengambil rekap semua riwayat pemesanan pendaki dari database. */
    public List<Object[]> generateLaporan() {
        List<Object[]> data = new ArrayList<>();
        String sql = "SELECT b.id_booking, p.nama, g.nama_gunung, j.nama_jalur, "
                + "b.tanggal_naik, b.status_booking, b.total_biaya "
                + "FROM booking b "
                + "JOIN pendaki pd ON b.id_pendaki = pd.id_pendaki "
                + "JOIN users p ON pd.id_user = p.id_user "
                + "JOIN gunung g ON b.id_gunung = g.id_gunung "
                + "JOIN jalur_pendakian j ON b.id_jalur = j.id_jalur "
                + "ORDER BY b.id_booking DESC";
        try (PreparedStatement ps = Koneksi.getInstance().getKoneksi().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                data.add(new Object[]{
                    rs.getInt("id_booking"),
                    rs.getString("nama"),
                    rs.getString("nama_gunung"),
                    rs.getString("nama_jalur"),
                    rs.getDate("tanggal_naik"),
                    rs.getString("status_booking"),
                    rs.getDouble("total_biaya")
                });
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
    }

    /** Menampilkan data laporan ke dalam JTable yang diberikan. */
    public void tampilkanKeTabel(JTable table) {
        String[] kolom = {"ID Booking", "Nama Pendaki", "Gunung", "Jalur", "Tgl Naik", "Status", "Total Biaya"};
        DefaultTableModel model = new DefaultTableModel(kolom, 0);
        for (Object[] row : generateLaporan()) {
            model.addRow(row);
        }
        table.setModel(model);
    }

    public void exportToPDF() {
        // Implementasi export PDF dapat memakai library iText / OpenPDF.
        JOptionPane.showMessageDialog(null, "Fitur cetak PDF memerlukan library tambahan "
                + "(misal iText/OpenPDF). Silakan tambahkan library tersebut ke project.");
    }

    public int getIdLaporan() {
        return idLaporan;
    }

    public void setIdLaporan(int idLaporan) {
        this.idLaporan = idLaporan;
    }

    public String getJenisLaporan() {
        return jenisLaporan;
    }

    public void setJenisLaporan(String jenisLaporan) {
        this.jenisLaporan = jenisLaporan;
    }
}
