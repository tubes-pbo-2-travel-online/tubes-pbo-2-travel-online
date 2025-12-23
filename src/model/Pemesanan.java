package model;

import java.time.LocalDateTime;

public class Pemesanan implements InfoDisplay {

    private Integer id;
    private Double totalHarga;
    private LocalDateTime tanggalPemesanan;
    private String status;
    private Penumpang penumpang;
    private Jadwal jadwal;
    private Kursi kursi;
    private Pembayaran pembayaran;

    public Pemesanan(Penumpang penumpang, Jadwal jadwal, Kursi kursi) {
        this.penumpang = penumpang;
        this.jadwal = jadwal;
        this.kursi = kursi;
        this.totalHarga = jadwal.getHarga();
        this.tanggalPemesanan = LocalDateTime.now();
        this.status = "Menunggu";
        kursi.setStatus("Terisi");
    }

    public void updateStatus(String status) {
        this.status = status;

        if (status.equalsIgnoreCase("Batal")) {
            kursi.setStatus("Kosong");
        }
    }

    @Override
    public void showInfo() {
        System.out.println("Pemesanan ID: " + id + " | Status: " + status + " | Total: " + totalHarga);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Penumpang getPenumpang() {
        return penumpang;
    }

    public Jadwal getJadwal() {
        return jadwal;
    }

    public Kursi getKursi() {
        return kursi;
    }

    public Double getTotalHarga() {
        return totalHarga;
    }

    public String getStatus() {
        return status;
    }

    public LocalDateTime getTanggalPemesanan() {
        return tanggalPemesanan;
    }

    public Pembayaran getPembayaran() { 
        return pembayaran;
    }

    public void setPembayaran(Pembayaran pembayaran) { 
        this.pembayaran = pembayaran; 
    }
}
