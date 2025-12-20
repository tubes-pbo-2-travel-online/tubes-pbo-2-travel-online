import ui.LoginMenu;

public class Main {
    
    public static void main(String[] args) {
        System.out.println("Memulai Aplikasi...");
        
        // 1. Buat objek menu login
        LoginMenu login = new LoginMenu();
        
        // 2. Tampilkan menunya
        login.tampilkan();
    }
}