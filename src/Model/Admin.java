package model;

public class Admin extends User {
    private int idAdmin;
    private String idKerja;

    public Admin() {
        super();
    }

    public void verifikasiPendaftaran() {
        
    }

    public void verifikasiPembayaran() {
        
    }

    public void kelolaJalurDanGunung() {
       
    }

    public void cetakLaporan() {
       
    }

    public int getIdAdmin() { return idAdmin; }
    public void setIdAdmin(int idAdmin) { this.idAdmin = idAdmin; }

    public String getIdKerja() { return idKerja; }
    public void setIdKerja(String idKerja) { this.idKerja = idKerja; }
}