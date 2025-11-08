import java.util.Scanner;
import java.text.DecimalFormat;
import java.util.Random;

//Aplikasi Self Service seperti McDonalds dls.
public class TiketBioskop {
    @SuppressWarnings("empty-statement")
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random r = new Random();
        
        DecimalFormat df = new DecimalFormat("#,###.00");
        String[] film = {"Star Wars","Transformers","A Quiet Place","A Quiet Place Part II"};
        String[] jam = {"10:00", "13:00", "16:00", "19:00", "21:00"};
        String[] Class = {"Reguler", "IMAX", "Premium", "Bed"};
        double[] hargaClass = {0, 10000, 45000, 235000};
        double[] hargaFilm = {60000, 50000, 45000, 65000};
        
        int jumlah, confirm, kodeFilm, cara, pilihJam, pilihClass;
        double total, bayar;
        double diskon1 = 0, diskon2 = 0, totalBayar;
        
        System.out.println("============= XXIX Cinema =============");
        System.out.println("Selamat datang di XXIX Cinema.");
        do {System.out.println("\n=================FILMS=================");
            System.out.println("1. Star Wars                :" + df.format(hargaFilm[0]));
            System.out.println("2. Transformers             :" + df.format(hargaFilm[1]));
            System.out.println("3. A Quiet Place            :" + df.format(hargaFilm[2]));
            System.out.println("4. A Quiet Place Part II    :" + df.format(hargaFilm[3]));
            System.out.println("\nDiskon 5% untuk pembelian >= 2 tiket.");
            System.out.println("Diskon 10% untuk total >= Rp200,000.00.");
            System.out.println("Diskon 5% untuk total >= Rp120,000.00.");
            System.out.println("=======================================");
            System.out.print("Pilih film [1-4]: ");
            kodeFilm = input.nextInt();
            System.out.println("\n===============CLASSES===============");
            System.out.println("1. Reguler  :" + hargaClass[0]);
            System.out.println("2. IMAX     :" + df.format(hargaClass[1]));
            System.out.println("3. Premium  :" + df.format(hargaClass[2]));
            System.out.println("4. Bed      :" + df.format(hargaClass[3]));
            System.out.println("=====================================");
            System.out.print("Pilih tiket Class [1-4]: ");
            pilihClass = input.nextInt();
            System.out.println("\n==========JAM TAYANG==========");
            System.out.println("1.  "+jam[0]);
            System.out.println("2.  "+jam[1]);
            System.out.println("3.  "+jam[2]);
            System.out.println("4.  "+jam[3]);
            System.out.println("5.  "+jam[4]);
            System.out.println("==============================");
            System.out.print("Pilih jam tayang [1-5]: ");
            pilihJam = input.nextInt();
            System.out.print("Jumlah pesan tiket: ");
            jumlah = input.nextInt();
            System.out.println("\nHarga tiket anda akan menjadi: " + (hargaFilm[kodeFilm-1] * jumlah + hargaClass[pilihClass-1]*jumlah));
            
            System.out.print("Pesan sekarang? \n[1] Ya! Pesan sekarang. \n[2] Kembali ke menu. \nKonfirmasi: ");
            confirm = input.nextInt();
        }while (confirm == 2);
        
        total = (hargaFilm[kodeFilm-1] * jumlah) + (hargaClass[pilihClass-1]) * jumlah;
        
        if (total >= 200000) {
            diskon1 = 0.10; // diskon 10%
        } else if (total >= 120000) {
            diskon1 = 0.05; // diskon 5%
        }
        
        if (jumlah >= 2){
            diskon2 = 0.05;
        }
        
        totalBayar = total - (total * (diskon1 + diskon2));
        
        System.out.println("\n=== Struk Pembayaran ===");
        System.out.println("Film        : " + film[kodeFilm-1]);
        System.out.println("Jam Tayang  : " + jam[pilihJam-1]);
        System.out.println("Harga Tiket : Rp" + df.format(hargaFilm[kodeFilm-1]));
        System.out.println("Class       : " + Class[pilihClass-1]);
        System.out.println("Harga Class : +" + (hargaClass[pilihClass-1]*jumlah));
        System.out.println("Jumlah Tiket: " + jumlah);
        System.out.println("Total       : Rp" + df.format(total));
        System.out.println("Diskon      : " + ((diskon1 * 100) + (diskon2 * 100)) + "%");
        System.out.println("Total Bayar : Rp" + df.format(totalBayar));
        
        System.out.println("===============================");
        System.out.print("Pilih sistem perbayaran: \n[1] Cash \n[2] E-Wallet \nPembayaran: ");
        cara = input.nextInt();
        if (cara == 1){
            int kodeBayar = r.nextInt(10000);
            System.out.println("Kode pembayaranmu adalah: " + kodeBayar);
            System.out.println("Silahkan lanjutkan pembayaran di kasir utama.");
        }
        else {
            System.out.println("Silahkan scan QR code berikut.");
            System.out.println("\n[QR]\n");
            System.out.print("Masukkan uang pembayaran: ");
            bayar = input.nextInt();
            System.out.println("Berhasil melakukan pembayaran sebesar Rp"+ bayar);
        }
        System.out.println("=== Selamat Menonton! ===");
    }
}