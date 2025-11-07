import java.util.Scanner;
import java.text.DecimalFormat;
import java.util.Random;

//Aplikasi Self Service seperti McDonalds dls.
public class TokoRoti {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random r = new Random();
        
        DecimalFormat df = new DecimalFormat("#,###.00");
        String[] roti = {"Roti Coklat","Roti Keju","Roti Piscok","Roti Daging"};
        double[] harga = {7000, 8000, 10000, 12000};
        
        String nomor;
        int jumlah, confirm, kode, cara;
        double total, bayar;
        double diskon = 0, totalBayar;
        
        System.out.println("=== Toko Roti Be'i ===");
        System.out.println("Selamat datang di Toko Roti Be'i. Silahkan lihat menu kamui semoga senang berbelanja!");
        do {System.out.println("Menu: \n================================== \n|Kode| |Nama: Harga|");
            System.out.println(" [1]     Roti Coklat : " + df.format(harga[0]));
            System.out.println(" [2]     Roti Keju   : " + df.format(harga[1]));
            System.out.println(" [3]     Roti Piscok : " + df.format(harga[2]));
            System.out.println(" [4]     Roti Daging : " + df.format(harga[3]));
            System.out.println("==================================");
            System.out.print("Masukkan kode roti: ");
            kode = input.nextInt();
            System.out.print("Masukkan jumlah roti: ");
            jumlah = input.nextInt();
            System.out.println("Harga pembelian anda akan menjadi: " + harga[kode-1] * jumlah);
            System.out.print("Yakin untuk membeli? \n[1]Yakin, beli sekarang. \n[2]Kembali ke menu. \nKonfirmasi: ");
            confirm = input.nextInt();
        }while (confirm == 2);
        
        total = harga[kode-1] * jumlah;
        
        if (total >= 100000) {
            diskon = 0.10; // diskon 10%
        } else if (total >= 50000) {
            diskon = 0.05; // diskon 5%
        }
        
        totalBayar = total - (total * diskon);
        
        System.out.println("\n=== Struk Pembayaran ===");
        System.out.println("Nama Barang : " + roti[kode-1]);
        System.out.println("Harga Barang: Rp " + df.format(harga[kode-1]));
        System.out.println("Jumlah      : " + jumlah);
        System.out.println("Total       : Rp " + df.format(total));
        System.out.println("Diskon      : " + (diskon * 100) + "%");
        System.out.println("Total Bayar : Rp " + df.format(totalBayar));
        
        System.out.println("===============================");
        System.out.print("Pilih sistem perbayaran: \n[1]Cash \n[2]E-Wallet \nPembayaran: ");
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
            System.out.println("Berhasil melakukan pembayaran sebesar "+ bayar);
        }
        System.out.println("=== Terima Kasih Telah Berbelanja! ===");
    }
}
