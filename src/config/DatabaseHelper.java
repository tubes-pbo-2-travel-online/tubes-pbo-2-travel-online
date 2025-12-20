package config;

import models.*;
import java.sql.*;

public class DatabaseHelper {

    private static Connection connect() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tiket_travel_db", "root", "");
        } catch (Exception e) {
            System.out.println("Koneksi Gagal: " + e.getMessage());
        }
        return conn;
    }

    public static Users cekLogin(String username, String password) {
        Users user = null;
        try {
            Connection conn = connect();
            String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("id");
                String nama = rs.getString("nama");
                String noTelp = rs.getString("nomor_telepon");
                String email = rs.getString("email");
                String role = rs.getString("role");

                // Buat Objek
                if (role.equals("admin")) {
                    user = new Admin(id, nama, noTelp, email, username, password);
                } else {
                    user = new Penumpang(id, nama, noTelp, email, username, password);
                }
            }
            conn.close();
        } catch (Exception e) { e.printStackTrace(); }
        return user;
    }

    public static void tampilkanJadwal() {
        try {
            Connection conn = connect();
            String sql = "SELECT * FROM jadwal";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            System.out.println("\n--- JADWAL TERSEDIA ---");
            while(rs.next()) {
                String asal = rs.getString("asal");
                String tujuan = rs.getString("tujuan");
                Date tgl = rs.getDate("tanggal");
                Time jam = rs.getTime("jam");
                double harga = rs.getDouble("harga");
                int sisaKursi = rs.getInt("total_kursi");

                System.out.println(asal + " -> " + tujuan + 
                                   " | " + tgl + " " + jam + 
                                   " | Rp" + harga + 
                                   " | Sisa Kursi: " + sisaKursi);
            }
            conn.close();
        } catch (Exception e) { e.printStackTrace(); }
    }
}