package ui;

import java.util.Scanner;
import model.Admin;

public class AdminMenu {

    private Admin admin;
    private Scanner scanner = new Scanner(System.in);

    public AdminMenu(Admin admin) {
        this.admin = admin;
    }

    public void show() {
        int pilihan;

        do {
            admin.viewDashboard();
            System.out.print("Pilih menu: ");
            pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1:
                    admin.kelolaJadwal();
                    break;

                case 2:
                    System.out.print("ID Pemesanan: ");
                    int idBayar = scanner.nextInt();
                    admin.verifikasiPembayaran(idBayar);
                    break;

                case 3:
                    System.out.print("ID Pemesanan: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Status baru: ");
                    String status = scanner.nextLine();
                    admin.ubahStatusPemesanan(id, status);
                    break;

                case 4:
                    admin.logout();
                    break;

                default:
                    System.out.println("Menu tidak valid!");
            }

        } while (pilihan != 4);
    }
}
