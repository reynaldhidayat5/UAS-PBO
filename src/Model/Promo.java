package model;

public class Promo {

    private int idPromo;
    private String kodePromo;
    private double diskon;

    public Promo() {
    }

    public Promo(int idPromo, String kodePromo, double diskon) {
        this.idPromo = idPromo;
        this.kodePromo = kodePromo;
        this.diskon = diskon;
    }

    /** Validasi sederhana: kode promo dianggap valid bila diskon > 0. */
    public boolean cekValidasi() {
        return kodePromo != null && !kodePromo.isEmpty() && diskon > 0;
    }

    public int getIdPromo() {
        return idPromo;
    }

    public void setIdPromo(int idPromo) {
        this.idPromo = idPromo;
    }

    public String getKodePromo() {
        return kodePromo;
    }

    public void setKodePromo(String kodePromo) {
        this.kodePromo = kodePromo;
    }

    public double getDiskon() {
        return diskon;
    }

    public void setDiskon(double diskon) {
        this.diskon = diskon;
    }
}
