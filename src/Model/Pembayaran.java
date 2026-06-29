package model;

public class Pembayaran {

    private int idBayar;
    private String metodePembayaran;
    private String statusPembayaran;
    private String buktiPembayaran;
    private int idBooking;

    public Pembayaran() {
    }

    public Pembayaran(int idBayar, String metodePembayaran, String statusPembayaran,
            String buktiPembayaran, int idBooking) {
        this.idBayar = idBayar;
        this.metodePembayaran = metodePembayaran;
        this.statusPembayaran = statusPembayaran;
        this.buktiPembayaran = buktiPembayaran;
        this.idBooking = idBooking;
    }

    public void uploadBuktiPembayaran() {
        // disimpan ke kolom buktiPembayaran via controller
    }

    public boolean prosesPembayaran() {
        this.statusPembayaran = "Lunas";
        return true;
    }

    public int getIdBayar() {
        return idBayar;
    }

    public void setIdBayar(int idBayar) {
        this.idBayar = idBayar;
    }

    public String getMethod() {
        return metodePembayaran;
    }

    public void setMethod(String method) {
        this.metodePembayaran = method;
    }

    public String getStatus() {
        return statusPembayaran;
    }

    public void setStatus(String status) {
        this.statusPembayaran = status;
    }

    public String getBuktiPembayaran() {
        return buktiPembayaran;
    }

    public void setBuktiPembayaran(String buktiPembayaran) {
        this.buktiPembayaran = buktiPembayaran;
    }

    public int getIdBooking() {
        return idBooking;
    }

    public void setIdBooking(int idBooking) {
        this.idBooking = idBooking;
    }
}
