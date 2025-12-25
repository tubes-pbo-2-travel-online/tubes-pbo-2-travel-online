package model;

public abstract class User {

    protected Integer id;
    protected String nama;
    protected String noTelp;
    protected String email;
    protected String username;
    protected String password;
    protected String role;

    public User(Integer id, String nama, String noTelp, String email,
                String username, String password, String role) {
        this.id = id;
        this.nama = nama;
        this.noTelp = noTelp;
        this.email = email;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNoTelp() {
        return noTelp;
    }

    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    protected String getPassword() {
        return password;
    }

    protected void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public boolean login(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    public void logout() {
        System.out.println("User berhasil logout.");
    }

    public abstract void viewDashboard();
}
