package service;

import util.DatabaseConnection;
import model.Pemesanan;
import model.Jadwal;
import model.Kursi;
import model.Penumpang;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PemesananService {

    public void simpanPemesanan(Pemesanan p) {
        String sql = "INSERT INTO pemesanan(user_id, jadwal_id, kursi_id, total_harga, tanggal_pemesanan, status) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setInt(1, p.getPenumpang().getId());
            ps.setInt(2, p.getJadwal().getId());
            ps.setInt(3, p.getKursi().getId());
            ps.setDouble(4, p.getTotalHarga());
            ps.setTimestamp(5, Timestamp.valueOf(p.getTanggalPemesanan()));
            ps.setString(6, p.getStatus());

            ps.executeUpdate();

        } catch (SQLException e) {e.printStackTrace(); }
    }

        public List<Pemesanan> getRiwayatByPenumpang(int userId) {
        List<Pemesanan> list = new ArrayList<>();
        String sql = "SELECT p.*, j.asal, j.tujuan, j.jam, j.harga, k.nomor_kursi " +
                     "FROM pemesanan p " +
                     "JOIN jadwal j ON p.jadwal_id = j.id " +
                     "JOIN kursi k ON p.kursi_id = k.id " +
                     "WHERE p.user_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
                Jadwal j = new Jadwal(0, rs.getString("asal"), rs.getString("tujuan"), "-", rs.getString("jam"), rs.getDouble("harga"), 0);
                Kursi k = new Kursi(0, rs.getInt("nomor_kursi"), j, "Terisi");
                
                Pemesanan p = new Pemesanan(null, j, k);
                p.setId(rs.getInt("id"));
                p.updateStatus(rs.getString("status"));
                list.add(p);
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return list;
    }

    public boolean updateStatusPemesanan(int id, String statusBaru) {
        String sql = "UPDATE pemesanan SET status = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, statusBaru);
            ps.setInt(2, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) { return false; }
    }
}
