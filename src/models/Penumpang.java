package models;

public class Penumpang extends Users {
    public Penumpang(int id, String nama, String notelp, String email, String user, String pass) {
        super(id, nama, notelp, email, user, pass, "penumpang");
    }

    @Override
    public void viewDashboard() {
        System.out.println("Dashboard Penumpang");
        System.out.println("Halo Kak " + this.nama);
        System.out.println("Email info: " + this.email);
    }
}