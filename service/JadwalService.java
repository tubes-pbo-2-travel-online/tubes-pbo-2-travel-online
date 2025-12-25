package service;

import util.DatabaseConnection;
import model.Jadwal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Kursi;

public class JadwalService {

    public List<Jadwal> getAllJadwal() {
        List<Jadwal> list = new ArrayList<>();
        String sql = "SELECT * FROM jadwal";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                list.add(new Jadwal(
                        rs.getInt("id"),
                        rs.getString("asal"),
                        rs.getString("tujuan"),
                        rs.getString("tanggal"),
                        rs.getString("jam"),
                        rs.getDouble("harga"),
                        rs.getInt("total_kursi")
                ));
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return list;
    }

    public boolean tambahJadwal(String asal, String tujuan, String tgl, String jam, double harga, int kuota) {
        String sql = "INSERT INTO jadwal (asal, tujuan, tanggal, jam, harga, total_kursi) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, asal); ps.setString(2, tujuan);
            ps.setString(3, tgl);  ps.setString(4, jam);
            ps.setDouble(5, harga); ps.setInt(6, kuota);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) { return false; }
    }
}
