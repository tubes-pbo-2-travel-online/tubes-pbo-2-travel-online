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

    private List<Kursi> daftarKursi;

    public Jadwal(Integer id, String asal, String tujuan,
                  String tanggal, String jam, Double harga) {
        this.id = id;
        this.asal = asal;
        this.tujuan = tujuan;
        this.tanggal = tanggal;
        this.jam = jam;
        this.harga = harga;
        this.daftarKursi = new ArrayList<>();
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

    public String getInfoJadwal() {
        return "Jadwal ID: " + id +
                " | " + asal + " → " + tujuan +
                " | Tanggal: " + tanggal +
                " | Jam: " + jam +
                " | Harga: " + harga;
    }

    public void tambahKursi(Kursi kursi) {
        daftarKursi.add(kursi);
    }

    public int getTotalKursiTersedia() {
        int total = 0;
        for (Kursi k : daftarKursi) {
            if (k.getStatus().equalsIgnoreCase("Kosong")) {
                total++;
            }
        }
        return total;
    }

    public void updateKursiTersedia() {
        System.out.println("Total kursi tersedia: " + getTotalKursiTersedia());
    }

    @Override
    public void showInfo() {
        System.out.println("Jadwal " + asal + " -> " + tujuan +
                " | " + tanggal + " " + jam +
                " | Harga: " + harga);
    }
}
