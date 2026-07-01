package model;

public class Booking {
    
    private int id_booking;
    private int id_pendaki;
    private int id_gunung;
    private int id_jalur;
    private String tanggal_naik;
    private String tanggal_turun;
    private int total_biaya;
    private String status_pembayaran;

    
    public Booking() {
    }

    
    public Booking(int id_booking, int id_pendaki, int id_gunung, int id_jalur, String tanggal_naik, String tanggal_turun, int total_biaya, String status_pembayaran) {
        this.id_booking = id_booking;
        this.id_pendaki = id_pendaki;
        this.id_gunung = id_gunung;
        this.id_jalur = id_jalur;
        this.tanggal_naik = tanggal_naik;
        this.tanggal_turun = tanggal_turun;
        this.total_biaya = total_biaya;
        this.status_pembayaran = status_pembayaran;
    }
    public static int cekKuotaTersisa(int aInt, int idGunung) {
        int kuotaMaksimal = 0;
        int totalDipesan = 0;

        
        String sqlGunung = "SELECT kuota FROM gunung WHERE id_gunung = ?";
        
       
        String sqlBooking = "SELECT COUNT(*) AS total FROM booking WHERE id_jalur = ? AND status_booking IN ('Pending', 'Lunas')";

        
        java.sql.Connection conn = config.Koneksi.getInstance().getKoneksi(); 

        try (java.sql.PreparedStatement psGunung = conn.prepareStatement(sqlGunung);
             java.sql.PreparedStatement psBooking = conn.prepareStatement(sqlBooking)) {
            
           
            psGunung.setInt(1, idGunung);
            try (java.sql.ResultSet rsGunung = psGunung.executeQuery()) {
                if (rsGunung.next()) {
                    kuotaMaksimal = rsGunung.getInt("kuota");
                }
            }

            
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

   
    
    public int getId_booking() {
        return id_booking;
    }

    public void setId_booking(int id_booking) {
        this.id_booking = id_booking;
    }

    public int getId_pendaki() {
        return id_pendaki;
    }

    public void setId_pendaki(int id_pendaki) {
        this.id_pendaki = id_pendaki;
    }

    public int getId_gunung() {
        return id_gunung;
    }

    public void setId_gunung(int id_gunung) {
        this.id_gunung = id_gunung;
    }

    public int getId_jalur() {
        return id_jalur;
    }

    public void setId_jalur(int id_jalur) {
        this.id_jalur = id_jalur;
    }

    public String getTanggal_naik() {
        return tanggal_naik;
    }

    public void setTanggal_naik(String tanggal_naik) {
        this.tanggal_naik = tanggal_naik;
    }

    public String getTanggal_turun() {
        return tanggal_turun;
    }

    public void setTanggal_turun(String tanggal_turun) {
        this.tanggal_turun = tanggal_turun;
    }

    public int getTotal_biaya() {
        return total_biaya;
    }

    public void setTotal_biaya(int total_biaya) {
        this.total_biaya = total_biaya;
    }

    public String getStatus_pembayaran() {
        return status_pembayaran;
    }

    public void setStatus_pembayaran(String status_pembayaran) {
        this.status_pembayaran = status_pembayaran;
    }
}