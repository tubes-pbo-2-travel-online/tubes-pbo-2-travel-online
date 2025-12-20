package ui;

import config.DatabaseHelper;
import java.util.Scanner;

public class AdminMenu {
    
    public void tampilkan() {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("\n=== MENU ADMIN ===");
            System.out.println("1. Lihat Daftar Jadwal");
            System.out.println("2. Logout");
            System.out.print("Pilih: ");
            
            String pilih = scanner.nextLine();

            switch (pilih) {
                case "1":
                    DatabaseHelper.tampilkanJadwal();

                    System.out.println("\n[Tekan Enter untuk kembali]");
                    scanner.nextLine();
                    break;
                    
                case "2":
                    System.out.println("Logout berhasil.");
                    isRunning = false;
                    break;
                    
                default:
                    System.out.println("Pilihan salah.");
            }
        }
    }
}