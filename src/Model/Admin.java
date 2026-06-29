package model;

public class Admin extends User {

    private int idAdmin;
    private String shiftKerja;

    public Admin() {
        super();
    }

    public Admin(int idAdmin, String nama, String email, String noHp, String password, String shiftKerja) {
        super(0, nama, email, noHp, password);
        this.idAdmin = idAdmin;
        this.shiftKerja = shiftKerja;
    }

    public void verifikasiPendaftaran() {
        // diimplementasikan melalui AdminController + PendakiController
    }

    public void verifikasiPembayaran() {
        // diimplementasikan melalui AdminController + PemesananController
    }

    public void kelolaJalurPendakian() {
        // diimplementasikan melalui AdminController
    }

    public void cetakLaporan(model.Laporan l) {
        if (l != null) {
            l.exportToPDF();
        }
    }

    public void bacaKritikSaran(model.Aduan_dan_Kritik_Saran r) {
        // menampilkan isi report pada DashboardAdmin
    }

    public int getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }

    public String getNamaAdmin() {
        return nama;
    }

    public void setNamaAdmin(String namaAdmin) {
        this.nama = namaAdmin;
    }

    public String getShift() {
        return shiftKerja;
    }

    public void setShift(String shift) {
        this.shiftKerja = shift;
    }
}
