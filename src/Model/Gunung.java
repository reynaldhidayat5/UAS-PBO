package model;

public class Gunung {

    private int idGunung;
    private String namaGunung;
    private String lokasi;
    private int kuota;

    public Gunung() {
    }

    public Gunung(int idGunung, String namaGunung, String lokasi, int kuota) {
        this.idGunung = idGunung;
        this.namaGunung = namaGunung;
        this.lokasi = lokasi;
        this.kuota = kuota;
    }

    public int getIdGunung() {
        return idGunung;
    }

    public void setIdGunung(int idGunung) {
        this.idGunung = idGunung;
    }

    public String getNamaGunung() {
        return namaGunung;
    }

    public void setNamaGunung(String namaGunung) {
        this.namaGunung = namaGunung;
    }

    public String getLokasi() {
        return lokasi;
    }

    public int getKuota() {
        return kuota;
    }

    public void setLokasiKuota(String lokasi, int kuota) {
        this.lokasi = lokasi;
        this.kuota = kuota;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    public void setKuota(int kuota) {
        this.kuota = kuota;
    }

    @Override
    public String toString() {
        return namaGunung;
    }
}
