package ui;

import java.util.Scanner;

public class PenumpangMenu {

    public void tampilkan() {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("\n=== MENU PENUMPANG ===");
            System.out.println("1. Cari Tiket");
            System.out.println("2. Cek Riwayat");
            System.out.println("3. Logout");
            System.out.print("Pilih: ");

            String pilih = scanner.nextLine();

            switch (pilih) {
                case "1":
                    System.out.println("[INFO] Fitur Cari Tiket sedang dibuat...");
                    break;
                case "2":
                    System.out.println("[INFO] Belum ada riwayat pesanan.");
                    break;
                case "3":
                    System.out.println("Sampai jumpa!");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }
}