package model;

public class Pendaki extends User {
    private int idPendaki;
    private String idKTP;
    private String nik;
    private String jeniskelamin;
    private String fotoKTP;
    private String kontakdarurat;

    public Pendaki() {
        super();
    }

    public boolean daftarPendaki() {
        // Logika pendaftaran akun pendaki baru
        return true;
    }

    public void riwayatPemesanan() {
        // Logika untuk menampilkan riwayat pemesanan pendaki
    }

    // Getters and Setters
    public int getIdPendaki() { return idPendaki; }
    public void setIdPendaki(int idPendaki) { this.idPendaki = idPendaki; }

    public String getIdKTP() { return idKTP; }
    public void setIdKTP(String idKTP) { this.idKTP = idKTP; }

    public String getNik() { return nik; }
    public void setNik(String nik) { this.nik = nik; }

    public String getJeniskelamin() { return jeniskelamin; }
    public void setJeniskelamin(String jeniskelamin) { this.jeniskelamin = jeniskelamin; }

    public String getFotoKTP() { return fotoKTP; }
    public void setFotoKTP(String fotoKTP) { this.fotoKTP = fotoKTP; }

    public String getKontakdarurat() { return kontakdarurat; }
    public void getKontakdarurat(String kontakdarurat) { this.kontakdarurat = kontakdarurat; }
}