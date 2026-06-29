package model;

import java.util.Date;

public class Booking {

    public static int cekKuotaTersisa(int aInt, int idGunung) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    private int idBooking;
    private Date tanggalNaik;
    private Date tanggalTurun;
    private String statusBooking;

   
    public Booking() {
    }

   
    public Booking(int idBooking, Date tanggalNaik, Date tanggalTurun, String statusBooking) {
        this.idBooking = idBooking;
        this.tanggalNaik = tanggalNaik;
        this.tanggalTurun = tanggalTurun;
        this.statusBooking = statusBooking;
    }

    
    public int getIdBooking() {
        return idBooking;
    }

    public void setIdBooking(int idBooking) {
        this.idBooking = idBooking;
    }

    public Date getTanggalNaik() {
        return tanggalNaik;
    }

    public void setTanggalNaik(Date tanggalNaik) {
        this.tanggalNaik = tanggalNaik;
    }

    public Date getTanggalTurun() {
        return tanggalTurun;
    }

    public void setTanggalTurun(Date tanggalTurun) {
        this.tanggalTurun = tanggalTurun;
    }

    public String getStatusBooking() {
        return statusBooking;
    }

    public void setStatusBooking(String statusBooking) {
        this.statusBooking = statusBooking;
    }
}