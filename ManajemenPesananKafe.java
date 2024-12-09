import java.util.Scanner;

public class ManajemenPesananKafe {
    static Scanner sc = new Scanner(System.in);

    static String[] daftarMenu = {"Kopi Hitam", "Latte", "Teh Tarik", "Mie Goreng"};
    static int[] hargaMenu = {15000, 22000, 12000, 18000};

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n================================");
            System.out.println("           MENU UTAMA           ");
            System.out.println("================================");
            System.out.println("1. Tambahkan Pesanan");
            System.out.println("2. Tampilkan Daftar Pesanan");
            System.out.println("3. Keluar");
            System.out.print("\nPilih menu: ");
            int pilihan = sc.nextInt();
            sc.nextLine();

            if (pilihan == 1) {
                // tambahPesanan();
            } else if (pilihan == 2) {
                // tampilkanPesanan();
            } else if (pilihan == 3) {
                System.out.println("\nTerima kasih telah menggunakan sistem manajemen pesanan!");
                break;
            } else {
                System.out.println("Pilihan tidak valid. Coba lagi.");
            }
        }
    }
}