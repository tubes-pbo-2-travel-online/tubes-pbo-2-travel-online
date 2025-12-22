package service;

import util.DatabaseConnection;
import model.User;
import model.Admin;
import model.Penumpang;

import java.sql.*;

public class AuthService {

    public User login(String username, String password) {
        String sql = "SELECT * FROM users WHERE username=? AND password=?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String role = rs.getString("role");

                if (role.equalsIgnoreCase("admin")) {
                    return new Admin(
                        rs.getInt("id"),
                        rs.getString("nama"),
                        rs.getString("no_telp"),
                        rs.getString("email"),
                        username,
                        password
                    );
                } else {
                    return new Penumpang(
                        rs.getInt("id"),
                        rs.getString("nama"),
                        rs.getString("no_telp"),
                        rs.getString("email"),
                        username,
                        password
                    );
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
