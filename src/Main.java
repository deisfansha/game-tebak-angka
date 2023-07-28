import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Membuat objek scanner
        Scanner input = new Scanner(System.in);
        // Membuat objek untuk angka acak
        Random random = new Random();
        boolean tebakBerhasil = true;

        int percobaan = 0;
        int randomNumber = random.nextInt(100)+1; // Mengambil angka acak kedalam variabel randomNumber

        System.out.println("Selamat datang di Permainan Tebak Angka!");
        System.out.println("Angka telah dipilih secara acak antara 1 hingga 100");
        System.out.println("Anda memiliki 1 menit untuk menebak angka tersebut");

        // Membuat sebuah objek Thread untuk timer.
        Thread timer = new Thread(() -> {
            try {
                Thread.sleep(60000); // Menunda thread selama 60000 milidetik (1 menit).
                System.out.println("Waktu telah habis "); // Setelah 1 menit berlalu, mencetak pesan "Waktu telah habis ".
                System.exit(0); // Menghentikan program dengan keluaran kode 0 (berhasil).
            } catch (InterruptedException e) {
                // Menangani pengecualian jika thread tidur terganggu.
                e.printStackTrace();
            }
        });

        timer.start(); // Memulai Timer
        while (tebakBerhasil){ // Mengulangi tebakan jika salah menebak
            System.out.println("\nMulai tebak angka");
            System.out.print("Tebak angka: ");
            int angka = input.nextInt(); // Memasukkan inputan
            percobaan++; // Menghitung percobaan input

            // Mengecek Kondisi
            // Kondisi dimana angka yang kita input sama dengan angka acak
            if (angka == randomNumber){
                System.out.println("Selamat, tebakan Anda benar");
                System.out.println("Anda berhasil menebak angka "+randomNumber+" dalam "+percobaan+ " kali percobaan");
                tebakBerhasil = false;
            // Kondisi dimana angka yang kita input lebih kecil dari angka acak
            }else if(angka < randomNumber){
                System.out.println("Tebakan terlalu rendah");
            // Kondisi dimana angka yang kita input lebih besar dari angka acak
            }else{
                System.out.println("Tebakan terlalu tinggi");
            }
        }

        System.out.println("Terima kasih telah bermain. Sampai Jumpa");
        input.close(); // Menutup Scanner
        timer.stop(); // Menghentikan timer jika tebakan berhasil

    }
}