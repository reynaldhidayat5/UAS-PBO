package model;

public class Tiket {

    private int idTiket;
    private String qrCode;
    private int idBooking;

    public Tiket() {
    }

    public Tiket(int idTiket, String qrCode, int idBooking) {
        this.idTiket = idTiket;
        this.qrCode = qrCode;
        this.idBooking = idBooking;
    }

    public void cetakTiket() {
        
    }

    public int getIdTiket() {
        return idTiket;
    }

    public void setIdTiket(int idTiket) {
        this.idTiket = idTiket;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public int getIdBooking() {
        return idBooking;
    }

    public void setIdBooking(int idBooking) {
        this.idBooking = idBooking;
    }
}
