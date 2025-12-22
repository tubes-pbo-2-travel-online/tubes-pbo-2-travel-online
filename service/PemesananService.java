package service;

import util.DatabaseConnection;
import model.Pemesanan;

import java.sql.*;

public class PemesananService {

    public void simpanPemesanan(Pemesanan p) {
        String sql = """
            INSERT INTO pemesanan(user_id, jadwal_id, kursi_id, total_harga, tanggal_pemesanan, status)
            VALUES (?, ?, ?, ?, ?, ?)
        """;

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, p.getPenumpang().getId());
            ps.setInt(2, p.getJadwal().getId());
            ps.setInt(3, p.getKursi().getId());
            ps.setDouble(4, p.getTotalHarga());
            ps.setTimestamp(5, Timestamp.valueOf(p.getTanggalPemesanan()));
            ps.setString(6, p.getStatus());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
