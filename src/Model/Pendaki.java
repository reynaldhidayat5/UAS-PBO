package model;

public class Pendaki extends User {
    private int idPendaki;
    private String idKTP;
    private String nik;
    private String status;
    private String fotoKTP;
    private String fotoSIM;

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

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getFotoKTP() { return fotoKTP; }
    public void setFotoKTP(String fotoKTP) { this.fotoKTP = fotoKTP; }

    public String getFotoSIM() { return fotoSIM; }
    public void setFotoSIM(String fotoSIM) { this.fotoSIM = fotoSIM; }
}