package service;

import util.DatabaseConnection;
import model.Jadwal;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
                        rs.getDouble("harga")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}
