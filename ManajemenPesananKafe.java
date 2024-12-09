import java.util.Scanner;

public class ManajemenPesananKafe {

    static String[][] daftarPesanan = new String[100][5];
    static int jumlahPesanan = 0;
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
                tambahPesanan();
            } else if (pilihan == 2) {
                tampilkanPesanan();
            } else if (pilihan == 3) {
                System.out.println("\nTerima kasih telah menggunakan sistem manajemen pesanan!");
                break;
            } else {
                System.out.println("Pilihan tidak valid. Coba lagi.");
            }
        }
    }

    static void tambahPesanan() {
        String namaPelanggan;
        int nomorMeja, totalHargaPesanan = 0;

        System.out.println("\n====================================");
        System.out.println("            FORM INPUT DATA          ");
        System.out.println("=====================================");
        System.out.print("\nMasukkan Nama Pelanggan: ");
        namaPelanggan = sc.nextLine();

        while (true) {
            System.out.print("Masukkan Nomor Meja: ");
            nomorMeja = sc.nextInt();

            String nmrMeja = Integer.toString(nomorMeja);
            boolean sudahTerisi = false;

            for (int i = 0; i < jumlahPesanan; i++) {
                if (daftarPesanan[i][1].equalsIgnoreCase(nmrMeja)) {
                    System.out.println("Nomor Meja '" + nomorMeja + "' sudah terisi.");
                    sudahTerisi = true;
                    break;
                }
            }

            if (!sudahTerisi) {
                break;
            }
        }

        System.out.println("\n===============================");
        System.out.println("          DAFTAR MENU          ");
        System.out.println("===============================");

        for (int i = 0; i < daftarMenu.length; i++) {
            System.out.println((i + 1) + ". " + daftarMenu[i] + " - Rp. " + hargaMenu[i]);
        }
        while (true) {
            System.out.print("\nPilih menu (masukkan nomor menu, atau 0 untuk selesai): ");
            int pilihanMenu = sc.nextInt();

            if (pilihanMenu == 0) {
                break;
            }

            if (pilihanMenu < 1 || pilihanMenu > daftarMenu.length) {
                System.out.println("Pilihan menu tidak valid. Coba lagi.");
                continue;
            }

            String namaMenu = daftarMenu[pilihanMenu - 1];
            int hargaSatuan = hargaMenu[pilihanMenu - 1];

            System.out.print("Masukkan jumlah item untuk " + namaMenu + ": ");
            int jumlahItem = sc.nextInt();

            if (jumlahItem <= 0) {
                System.out.println("Jumlah item harus lebih dari 0.");
                continue;
            }

            int totalHarga = jumlahItem * hargaSatuan;
            totalHargaPesanan += totalHarga;

            daftarPesanan[jumlahPesanan][0] = namaPelanggan;
            daftarPesanan[jumlahPesanan][1] = String.valueOf(nomorMeja);
            daftarPesanan[jumlahPesanan][2] = namaMenu;
            daftarPesanan[jumlahPesanan][3] = String.valueOf(jumlahItem);
            daftarPesanan[jumlahPesanan][4] = String.valueOf(totalHarga);
            jumlahPesanan++;
        }

        System.out.println("\nPesanan berhasil ditambahkan.");
        System.out.println("Total harga pesanan: Rp" + totalHargaPesanan);
    }

    static void tampilkanPesanan() {
        String pelangganTerakhir = "", mejaTerakhir = "";

        System.out.println("\n==================================");
        System.out.println("          DAFTAR PESANAN          ");
        System.out.println("==================================");

        if (jumlahPesanan == 0) {
            System.out.println("Belum ada pesanan yang dicatat.");
        }

        for (int i = 0; i < jumlahPesanan; i++) {
            String namaPelanggan = daftarPesanan[i][0];
            String nomorMeja = daftarPesanan[i][1];
    
            if (!namaPelanggan.equals(pelangganTerakhir) || !nomorMeja.equals(mejaTerakhir)) {
                pelangganTerakhir = namaPelanggan;
                mejaTerakhir = nomorMeja;
    
                int totalHargaPesanan = 0;
    
                System.out.println("Nama Pelanggan: " + namaPelanggan);
                System.out.println("Nomor Meja: " + nomorMeja);
                System.out.println("Detail Pesanan:");
    
                for (int j = 0; j < jumlahPesanan; j++) {
                    if (daftarPesanan[j][0].equals(namaPelanggan) && daftarPesanan[j][1].equals(nomorMeja)) {
                        String namaMenu = daftarPesanan[j][2];
                        int jumlahItem = Integer.parseInt(daftarPesanan[j][3]);
                        int hargaTotal = Integer.parseInt(daftarPesanan[j][4]);
    
                        System.out.println("- " + namaMenu + " x " + jumlahItem + " = Rp. " + hargaTotal);
                        totalHargaPesanan += hargaTotal;
                    }
                }
    
                System.out.println("Total Harga Pesanan: Rp. " + totalHargaPesanan);
                System.out.println("----------------------------------");
            }
        }
    }
    
}