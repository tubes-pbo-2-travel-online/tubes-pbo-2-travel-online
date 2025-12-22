package model;

import java.util.ArrayList;
import java.util.List;

public class Penumpang extends User {

    private List<Pemesanan> riwayatPemesanan;

    public Penumpang(Integer id, String nama, String noTelp, String email,
                     String username, String password) {
        super(id, nama, noTelp, email, username, password, "penumpang");
        this.riwayatPemesanan = new ArrayList<>();
    }

    @Override
    public void viewDashboard() {
        System.out.println("=== Dashboard Penumpang ===");
        System.out.println("1. Pesan Tiket");
        System.out.println("2. Lihat Riwayat Pemesanan");
        System.out.println("3. Bayar Pesanan");
        System.out.println("4. Logout");
    }

    public Pemesanan pesanTiket(Jadwal jadwal, Kursi kursi) {
        Pemesanan pemesanan = new Pemesanan(this, jadwal, kursi);
        riwayatPemesanan.add(pemesanan);

        System.out.println("Tiket berhasil dipesan.");
        return pemesanan;
    }

    public boolean bayar(Integer idPemesanan) {
        for (Pemesanan p : riwayatPemesanan) {
            if (p.getId().equals(idPemesanan)) {
                p.updateStatus("Dibayar");
                System.out.println("Pembayaran berhasil untuk pemesanan ID: " + idPemesanan);
                return true;
            }
        }
        System.out.println("Pemesanan tidak ditemukan.");
        return false;
    }

    public void lihatRiwayat() {
        System.out.println("=== Riwayat Pemesanan ===");
        if (riwayatPemesanan.isEmpty()) {
            System.out.println("Belum ada pemesanan.");
        } else {
            for (Pemesanan p : riwayatPemesanan) {
                System.out.println(p);
            }
        }
    }

    public List<Pemesanan> getRiwayatPemesanan() {
        return riwayatPemesanan;
    }
}
