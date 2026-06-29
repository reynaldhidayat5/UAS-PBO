package model;

/**
 * Class dasar User. Admin dan Pendaki merupakan turunan (extends) dari class ini.
 */
public class User {

    protected int idUser;
    protected String nama;
    protected String email;
    protected String noHp;
    protected String password;

    public User() {
    }

    public User(int idUser, String nama, String email, String noHp, String password) {
        this.idUser = idUser;
        this.nama = nama;
        this.email = email;
        this.noHp = noHp;
        this.password = password;
    }

    public boolean login() {
        // logika login sesungguhnya ditangani oleh AuthController
        return this.email != null && this.password != null;
    }

    public void logout() {
        this.idUser = 0;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNoHp() {
        return noHp;
    }

    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }
}
