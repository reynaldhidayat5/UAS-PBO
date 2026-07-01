package model;

public class Pendaki extends User {

    private int idPendaki;
    private String fotoKTP;
    private String nik;
    private String alamat;
    private String kontakDarurat;
    private String jenisKelamin;

    public Pendaki(int aInt, int idUser1, String string, String string1, String string2, String string3, String string4) {
        super();
    }
    

    public Pendaki(int idPendaki, String nama, String email, String noHp, String password,
            String nik, String fotoKTP, String alamat, String kontakDarurat, String jenisKelamin) {
        super(0, nama, email, noHp, password);
        this.idPendaki = idPendaki;
        this.nik = nik;
        this.fotoKTP = fotoKTP;
        this.alamat = alamat;
        this.kontakDarurat = kontakDarurat;
        this.jenisKelamin = jenisKelamin;
    }

    public boolean daftarPendakian() {
        return true;
    }

    public void kirimKritikSaran(Aduan_dan_Kritik_Saran r) {
        if (r != null) {
            r.simpanAduan();
        }
    }

    public int getIdPendaki() {
        return idPendaki;
    }

    public void setIdPendaki(int idPendaki) {
        this.idPendaki = idPendaki;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getFotoKTP() {
        return fotoKTP;
    }

    public void setFotoKTP(String fotoKTP) {
        this.fotoKTP = fotoKTP;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getKDarurat() {
        return kontakDarurat;
    }

    public void setKDarurat(String kontakDarurat) {
        this.kontakDarurat = kontakDarurat;
    }

    public String getJKel() {
        return jenisKelamin;
    }

    public void setJKel(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

   
}
