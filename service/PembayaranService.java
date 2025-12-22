package service;

import util.DatabaseConnection;

import java.sql.*;

public class PembayaranService {

    public void simpanPembayaran(int pemesananId, String metode, String bukti) {
        String sql = """
            INSERT INTO pembayaran(pemesanan_id, metode, bukti, status, tanggal_pembayaran)
            VALUES (?, ?, ?, 'Menunggu', NOW())
        """;

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, pemesananId);
            ps.setString(2, metode);
            ps.setString(3, bukti);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
