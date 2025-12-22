package ui;

import java.util.Scanner;
import model.Admin;
import model.Penumpang;
import model.User;

public class LoginMenu {

    private Scanner scanner = new Scanner(System.in);

    public void show() {
        System.out.println("=== SISTEM PEMESANAN TIKET TRAVEL ===");

        System.out.print("Username: ");
        String username = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

        User user;

        if (username.equals("admin")) {
            user = new Admin(1, "Admin", "-", "-", "admin", "admin");
        } else {
            user = new Penumpang(2, "Penumpang", "08123", "user@mail.com",
                    username, password);
        }

        if (user.login(username, password)) {
            System.out.println("Login berhasil!\n");

            if (user.getRole().equals("admin")) {
                new AdminMenu((Admin) user).show();
            } else {
                new PenumpangMenu((Penumpang) user).show();
            }

        } else {
            System.out.println("Login gagal!");
        }
    }
}
