package ui;

import java.util.Scanner;
import model.Admin;
import service.JadwalService;
import service.PemesananService;

public class AdminMenu {
    private Admin admin;
    private Scanner scanner = new Scanner(System.in);
    private JadwalService jadwalService = new JadwalService();
    private PemesananService pemesananService = new PemesananService();

    public AdminMenu(Admin admin) {
        this.admin = admin;
    }

    public void show() {
        int pilihan;
        do {
            System.out.println();
            admin.viewDashboard();
            System.out.print("Pilih menu: ");
            pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.println("1. Lihat Jadwal | 2. Tambah Jadwal");
                    System.out.print("Aksi: ");
                    int sub = scanner.nextInt(); scanner.nextLine();
                    if (sub == 1) {
                        jadwalService.getAllJadwal().forEach(j -> j.showInfo());
                    } else {
                        System.out.print("Asal: "); String asal = scanner.nextLine();
                        System.out.print("Tujuan: "); String tujuan = scanner.nextLine();
                        System.out.print("Tgl (YYYY-MM-DD): "); String tgl = scanner.nextLine();
                        System.out.print("Jam: "); String jam = scanner.nextLine();
                        System.out.print("Harga: "); double harga = scanner.nextDouble();
                        System.out.print("Kursi: "); int kuota = scanner.nextInt();
                        jadwalService.tambahJadwal(asal, tujuan, tgl, jam, harga, kuota);
                        System.out.println("Jadwal tersimpan!");
                    }
                    break;

                case 2:
                    System.out.print("Masukkan ID Pemesanan yang mau diverifikasi: ");
                    int idVerif = scanner.nextInt();
                    if (admin.verifikasiPembayaran(idVerif)) {
                        pemesananService.updateStatusPemesanan(idVerif, "Dibayar");
                        System.out.println("Status database diupdate menjadi 'Dibayar'.");
                    }
                    break;

                case 3:
                    System.out.print("Masukkan ID Pemesanan: ");
                    int idUbah = scanner.nextInt(); scanner.nextLine();
                    System.out.print("Masukkan Status Baru (Sukses/Batal): ");
                    String statusBaru = scanner.nextLine();
                    
                    admin.ubahStatusPemesanan(idUbah, statusBaru);
                    pemesananService.updateStatusPemesanan(idUbah, statusBaru);
                    System.out.println("Status berhasil diubah!");
                    break;

                case 4:
                    admin.logout();
                    break;

                default:
                    System.out.println("Plihan tidak valid!");
            }
        } while (pilihan != 4);
    }
}
