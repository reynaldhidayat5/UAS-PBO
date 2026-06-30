package model;

import java.util.Date;

public class Booking {

    public Booking() {
    }

    public static int cekKuotaTersisa(int aInt, int idGunung) {
        int kuotaMaksimal = 0;
        int totalDipesan = 0;

        // 1. PERBAIKAN: Ambil kuota dari tabel 'gunung', bukan jalur_pendakian
        String sqlGunung = "SELECT kuota FROM gunung WHERE id_gunung = ?";
        
        // 2. Hitung jumlah tiket/booking yang aktif di jalur tersebut
        String sqlBooking = "SELECT COUNT(*) AS total FROM booking WHERE id_jalur = ? AND status_booking IN ('Pending', 'Lunas')";

        // 3. PERBAIKAN PENTING: Deklarasikan koneksi DI LUAR dalam kurung try 
        // agar koneksi utama TIDAK TER-CLOSE otomatis dan mematikan BookingController
        java.sql.Connection conn = config.Koneksi.getInstance().getKoneksi(); 

        try (java.sql.PreparedStatement psGunung = conn.prepareStatement(sqlGunung);
             java.sql.PreparedStatement psBooking = conn.prepareStatement(sqlBooking)) {
            
            // Masukkan idGunung ke dalam query Gunung
            psGunung.setInt(1, idGunung);
            try (java.sql.ResultSet rsGunung = psGunung.executeQuery()) {
                if (rsGunung.next()) {
                    kuotaMaksimal = rsGunung.getInt("kuota");
                }
            }

            // Masukkan aInt (idJalur) ke dalam query Booking
            psBooking.setInt(1, aInt);
            try (java.sql.ResultSet rsBooking = psBooking.executeQuery()) {
                if (rsBooking.next()) {
                    totalDipesan = rsBooking.getInt("total");
                }
            }

        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }

        int sisaKuota = kuotaMaksimal - totalDipesan;
        return sisaKuota >= 0 ? sisaKuota : 0; 
    }

    // --- PROPERTY GETTER SETTER ---
    private int idBooking;
    private Date tanggalNaik;
    private Date tanggalTurun;
    private String statusBooking;

    public int getIdBooking() { return idBooking; }
    public void setIdBooking(int idBooking) { this.idBooking = idBooking; }
    public Date getTanggalNaik() { return tanggalNaik; }
    public void setTanggalNaik(Date tanggalNaik) { this.tanggalNaik = tanggalNaik; }
    public Date getTanggalTurun() { return tanggalTurun; }
    public void setTanggalTurun(Date tanggalTurun) { this.tanggalTurun = tanggalTurun; }
    public String getStatusBooking() { return statusBooking; }
    public void setStatusBooking(String statusBooking) { this.statusBooking = statusBooking; }
}