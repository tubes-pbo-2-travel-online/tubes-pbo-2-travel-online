package model;

import java.util.ArrayList;
import java.util.List;

public class Jadwal implements InfoDisplay {

    private Integer id;
    private String asal;
    private String tujuan;
    private String tanggal;
    private String jam;
    private Double harga;
    private Integer totalKursi;

    private List<Kursi> daftarKursi;

    public Jadwal(Integer id, String asal, String tujuan,String tanggal, String jam, Double harga, Integer totalKursi) {
        this.id = id;
        this.asal = asal;
        this.tujuan = tujuan;
        this.tanggal = tanggal;
        this.jam = jam;
        this.harga = harga;
        this.totalKursi = totalKursi;
        this.daftarKursi = new ArrayList<>();
    }

    public void updateKursiTersedia() {
        int sisa = 0;
        for(Kursi k : daftarKursi) {
            if(k.cekKetersediaan()) sisa++;
        }
        System.out.println("Kursi tersisa: " + sisa);
    }

    @Override
    public void showInfo() {
        System.out.println("Jadwal " + asal + " -> " + tujuan + " | " + tanggal + " " + jam + " | Harga: " + harga);
    }

    public Integer getId() {
        return id;
    }

    public String getAsal() {
        return asal;
    }

    public String getTujuan() {
        return tujuan;
    }

    public String getTanggal() {
        return tanggal;
    }

    public String getJam() {
        return jam;
    }

    public Double getHarga() {
        return harga;
    }

    public List<Kursi> getDaftarKursi() {
        return daftarKursi;
    }
}