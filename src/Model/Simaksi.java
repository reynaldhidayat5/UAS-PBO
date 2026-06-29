package model;

import java.util.Date;

public class Simaksi {

    private int idSimaksi;
    private String kodeSimaksi;
    private Date tanggalTerbit;
    private int idBooking;

    public Simaksi() {
    }

    public Simaksi(int idSimaksi, String kodeSimaksi, Date tanggalTerbit, int idBooking) {
        this.idSimaksi = idSimaksi;
        this.kodeSimaksi = kodeSimaksi;
        this.tanggalTerbit = tanggalTerbit;
        this.idBooking = idBooking;
    }

    public void cetakSimaksi() {
        // logika export/cetak surat izin (Simaksi) ke PDF
    }

    public int getIdSimaksi() {
        return idSimaksi;
    }

    public void setIdSimaksi(int idSimaksi) {
        this.idSimaksi = idSimaksi;
    }

    public String getKode() {
        return kodeSimaksi;
    }

    public void setKode(String kode) {
        this.kodeSimaksi = kode;
    }

    public Date getTglTrbt() {
        return tanggalTerbit;
    }

    public void setTglTrbt(Date tglTrbt) {
        this.tanggalTerbit = tglTrbt;
    }

    public int getIdBooking() {
        return idBooking;
    }

    public void setIdBooking(int idBooking) {
        this.idBooking = idBooking;
    }
}
