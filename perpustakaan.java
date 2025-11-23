import java.util.Scanner;

public class perpustakaan {
    public static void main(String[] args) {
        String[] buku = {
            "Hujan - Tere Liye",
            "Janji - Tere Liye",
            "Tentang Kamu - Tere Liye",
            "Pulang - Tere Liye",
            "Pergi - Tere Liye"
        };
        boolean[] terpinjam = new boolean[buku.length];
        Scanner sc = new Scanner(System.in);

        int pilih;
        do {
            System.out.println("\n=== Menu Perpustakaan ===");
            System.out.println("1. Lihat daftar buku");
            System.out.println("2. Pinjam buku");
            System.out.println("3. Kembalikan buku");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu: ");
            pilih = sc.nextInt();
            sc.nextLine();

            switch (pilih) {
                case 1:
                    System.out.println("\nDaftar Buku:");
                    for (int i = 0; i < buku.length; i++) {
                        System.out.println((i+1) + ". " + buku[i] + 
                            (terpinjam[i] ? " (Dipinjam)" : " (Tersedia)"));
                    }
                    break;
                case 2:
                    System.out.print("Masukkan nomor buku yang ingin dipinjam: ");
                    int pinjam = sc.nextInt() - 1;
                    if (pinjam >= 0 && pinjam < buku.length) {
                        if (!terpinjam[pinjam]) {
                            terpinjam[pinjam] = true;
                            System.out.println(buku[pinjam] + " berhasil dipinjam.");
                        } else {
                            System.out.println("Buku sudah dipinjam orang lain.");
                        }
                    } else {
                        System.out.println("Nomor buku tidak valid.");
                    }
                    break;
                case 3:
                    System.out.print("Masukkan nomor buku yang ingin dikembalikan: ");
                    int kembali = sc.nextInt() - 1;
                    if (kembali >= 0 && kembali < buku.length) {
                        if (terpinjam[kembali]) {
                            terpinjam[kembali] = false;
                            System.out.println(buku[kembali] + " berhasil dikembalikan.");
                        } else {
                            System.out.println("Buku tidak sedang dipinjam.");
                        }
                    } else {
                        System.out.println("Nomor buku tidak valid.");
                    }
                    break;
                case 4:
                    System.out.println("Terima kasih telah menggunakan sistem perpustakaan!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilih != 4);

        sc.close();
    }
}
