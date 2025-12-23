package model;

import java.time.LocalDateTime;

public class Pembayaran {

    private Integer id;
    private String metode;            
    private String bukti;             
    private String status;
    
    private Pemesanan pemesanan;

    public Pembayaran(Integer id, Pemesanan pemesanan, String metode, String bukti) {
        this.id = id;
        this.pemesanan = pemesanan;
        this.metode = metode;
        this.bukti = bukti;
        this.status = "Menunggu";
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

    public String getStatus() {
        return status;
    }
}
