package model;

import java.time.LocalDateTime;

public class Pembayaran {

    private Integer id;
    private String metode;            
    private String bukti;             
    private String status;           
    private Pemesanan pemesanan;      
    private LocalDateTime tanggalPembayaran;

    public Pembayaran(Integer id, Pemesanan pemesanan, String metode, String bukti) {
        this.id = id;
        this.pemesanan = pemesanan;
        this.metode = metode;
        this.bukti = bukti;
        this.status = "Menunggu";
        this.tanggalPembayaran = LocalDateTime.now();
    }

    public boolean validasiPembayaran() {
        if (bukti != null && !bukti.isEmpty()) {
            status = "Valid";
            pemesanan.updateStatus("Dibayar");
            return true;
        } else {
            status = "Invalid";
            return false;
        }
    }


    public Integer getId() {
        return id;
    }

    public Pemesanan getPemesanan() {
        return pemesanan;
    }

    public String getMetode() {
        return metode;
    }

    public void setMetode(String metode) {
        this.metode = metode;
    }

    public String getBukti() {
        return bukti;
    }

    public void setBukti(String bukti) {
        this.bukti = bukti;
    }

    public LocalDateTime getTanggalPembayaran() {
        return tanggalPembayaran;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Pembayaran{" +
                "id=" + id +
                ", metode='" + metode + '\'' +
                ", status='" + status + '\'' +
                ", tanggal=" + tanggalPembayaran +
                '}';
    }
}
