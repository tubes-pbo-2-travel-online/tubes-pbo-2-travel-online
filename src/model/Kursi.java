package model;

public class Kursi {

    private Integer id;
    private Integer nomorKursi;
    private String status; 
    private Jadwal jadwal; 

    public Kursi(Integer id, Integer nomorKursi, Jadwal jadwal, String status) {
        this.id = id;
        this.nomorKursi = nomorKursi;
        this.jadwal = jadwal;
        this.status = status; 
    }


    public Integer getId() {
        return id;
    }

    public Integer getNomorKursi() {
        return nomorKursi;
    }

    public String getStatus() {
        return status;
    }

    public Jadwal getJadwal() {
        return jadwal;
    }

    public boolean cekKetersediaan() {
        return status.equalsIgnoreCase("Kosong");
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Kursi " + nomorKursi + " (" + status + ")";
    }
}
