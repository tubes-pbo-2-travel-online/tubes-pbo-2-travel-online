package ui;

import config.DatabaseHelper;
import models.Users;
import java.util.Scanner;

public class LoginMenu {
    Scanner scanner = new Scanner(System.in);

    public void tampilkan() {
        System.out.println("\n=== LOGIN TIKET TRAVEL ===");
        System.out.print("Username: ");
        String u = scanner.nextLine();
        System.out.print("Password: ");
        String p = scanner.nextLine();

        // Panggil Helper (yang sudah direvisi tadi)
        Users hasil = DatabaseHelper.cekLogin(u, p);

        if (hasil != null) {
            // Berhasil Login
            hasil.viewDashboard(); // Polimorfisme jalan disini

            // Cek Role untuk redirect menu
            if (hasil.getRole().equals("admin")) {
                new AdminMenu().tampilkan(); 
            } else {
                new PenumpangMenu().tampilkan();
            }
        } else {
            System.out.println("[!] Login Gagal. User tidak ditemukan.");
        }
    }
}