package model;

public class User {
    private int idUser;
    private String nama;
    private String email;
    private String noTelp;
    private String password;

    public User() {}

    public User(int idUser, String nama, String email, String noTelp, String password) {
        this.idUser = idUser;
        this.nama = nama;
        this.email = email;
        this.noTelp = noTelp;
        this.password = password;
    }

    public boolean login() {
        
        return true;
    }

    public void logout() {
        
    }

    // Getters and Setters
    public int getIdUser() { return idUser; }
    public void setIdUser(int idUser) { this.idUser = idUser; }

    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getNoTelp() { return noTelp; }
    public void setNoTelp(String noTelp) { this.noTelp = noTelp; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}