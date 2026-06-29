package model;

public class Jalur_Pendakian {

    private int idJalur;
    private String namaJalur;
    private String statusJalur;
    private int idGunung;
    private String deskripsiJalur;
    private String fotoEstimasiWaktu;

    public Jalur_Pendakian() {
    }

    public Jalur_Pendakian(int idJalur, String namaJalur, String statusJalur, int idGunung,
            String deskripsiJalur, String fotoEstimasiWaktu) {
        this.idJalur = idJalur;
        this.namaJalur = namaJalur;
        this.statusJalur = statusJalur;
        this.idGunung = idGunung;
        this.deskripsiJalur = deskripsiJalur;
        this.fotoEstimasiWaktu = fotoEstimasiWaktu;
    }

    public int getIdJalur() {
        return idJalur;
    }

    public void setIdJalur(int idJalur) {
        this.idJalur = idJalur;
    }

    public String getNamaJalur() {
        return namaJalur;
    }

    public void setNamaJalur(String namaJalur) {
        this.namaJalur = namaJalur;
    }

    public String getStatusJalur() {
        return statusJalur;
    }

    public void setStatusJalur(String statusJalur) {
        this.statusJalur = statusJalur;
    }

    public int getIdGunung() {
        return idGunung;
    }

    public void setIdGunung(int idGunung) {
        this.idGunung = idGunung;
    }

    public String getDeskripsiJalur() {
        return deskripsiJalur;
    }

    public void setDeskripsiJalur(String deskripsiJalur) {
        this.deskripsiJalur = deskripsiJalur;
    }

    public String getFotoEstimasiWaktu() {
        return fotoEstimasiWaktu;
    }

    public void setFotoEstimasiWaktu(String fotoEstimasiWaktu) {
        this.fotoEstimasiWaktu = fotoEstimasiWaktu;
    }

    @Override
    public String toString() {
        return namaJalur;
    }
}
