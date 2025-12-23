package ui;

import java.util.Scanner;
import java.util.List;
import model.*;
import service.JadwalService;
import service.PemesananService;

public class PenumpangMenu {
    private Penumpang penumpang;
    private Scanner scanner = new Scanner(System.in);
    private JadwalService jadwalService = new JadwalService();
    private PemesananService pemesananService = new PemesananService();

    public PenumpangMenu(Penumpang penumpang) {
        this.penumpang = penumpang;
    }

    public void show() {
        int pilihan;
        do {
            System.out.println();
            penumpang.viewDashboard();
            System.out.print("Pilih menu: ");
            pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.println("--- PILIH JADWAL ---");
                    List<Jadwal> list = jadwalService.getAllJadwal();
                    for(int i=0; i<list.size(); i++) {
                        System.out.print((i+1)+". "); list.get(i).showInfo();
                    }
                    System.out.print("Pilih nomor: ");
                    int idx = scanner.nextInt();
                    
                    if(idx > 0 && idx <= list.size()) {
                        Jadwal dipilih = list.get(idx-1);
                        Kursi kursi = new Kursi(0, 1, dipilih, "Kosong");
                        
                        Pemesanan p = penumpang.pesanTiket(dipilih, kursi);
                        
                        pemesananService.simpanPemesanan(p);
                        System.out.println("Pesanan disimpan ke Database! Status: Menunggu");
                    }
                    break;

                case 2:
                    System.out.println("--- RIWAYAT PESANAN SAYA ---");
                    List<Pemesanan> history = pemesananService.getRiwayatByPenumpang(penumpang.getId());
                    
                    if(history.isEmpty()) {
                        System.out.println("Belum ada riwayat pesanan.");
                    } else {
                        for(Pemesanan p : history) {
                            System.out.println("ID: " + p.getId() + 
                                               " | Tujuan: " + p.getJadwal().getTujuan() + 
                                               " | Status: " + p.getStatus());
                        }
                    }
                    break;

                case 3:
                    System.out.print("Masukkan ID Pemesanan yang mau dibayar: ");
                    int idBayar = scanner.nextInt();

                    if (penumpang.bayar(idBayar)) {
                        System.out.println("(Simulasi: Mengirim bukti pembayaran...)");
                        System.out.println("Silakan minta Admin memverifikasi ID " + idBayar);
                    }
                    break;
                case 4:
                    penumpang.logout();
                    break;

                default:
                    System.out.println("Pilihan tidak valid!");
            }
        } while (pilihan != 4);
    }
}
