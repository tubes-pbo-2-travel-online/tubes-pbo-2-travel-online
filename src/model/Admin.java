package model;

public class Admin extends User {

    public Admin(Integer id, String nama, String noTelp, String email,
                 String username, String password) {
        super(id, nama, noTelp, email, username, password, "admin");
    }


    @Override
    public void viewDashboard() {
        System.out.println("=== Dashboard Admin ===");
        System.out.println("1. Kelola Jadwal");
        System.out.println("2. Verifikasi Pembayaran");
        System.out.println("3. Ubah Status Pemesanan");
        System.out.println("4. Logout");
    }

    public void kelolaJadwal() {
        System.out.println("Admin sedang mengelola jadwal travel...");
    }

   
    public boolean verifikasiPembayaran(Integer idPemesanan) {
        System.out.println("Memverifikasi pembayaran untuk pemesanan ID: " + idPemesanan);
        return true; // simulasi berhasil
    }

    
    public void ubahStatusPemesanan(Integer idPemesanan, String status) {
        System.out.println("Status pemesanan ID " + idPemesanan +
                " diubah menjadi: " + status);
    }
}
