package ui;

import java.util.Scanner;
import model.*;

public class PenumpangMenu {

    private Penumpang penumpang;
    private Scanner scanner = new Scanner(System.in);

    public PenumpangMenu(Penumpang penumpang) {
        this.penumpang = penumpang;
    }

    public void show() {
        int pilihan;

        do {
            penumpang.viewDashboard();
            System.out.print("Pilih menu: ");
            pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1:
                    Jadwal jadwal = new Jadwal(1, "Bandung", "Jakarta",
                            "2025-01-01", "08:00", 100000.0);
                    Kursi kursi = new Kursi(1, 1, jadwal, "Kosong");

                    Pemesanan p = penumpang.pesanTiket(jadwal, kursi);
                    System.out.println(p);
                    break;

                case 2:
                    penumpang.lihatRiwayat();
                    break;

                case 3:
                    System.out.print("ID Pemesanan: ");
                    int idBayar = scanner.nextInt();
                    penumpang.bayar(idBayar);
                    break;

                case 4:
                    penumpang.logout();
                    break;

                default:
                    System.out.println("Menu tidak valid!");
            }

        } while (pilihan != 4);
    }
}
