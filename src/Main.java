import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Membuat objek scanner untuk menerima input dari pengguna
        Scanner input = new Scanner(System.in);

        // Membuat objek untuk menghasilkan angka acak
        Random random = new Random();

        // Inisialisasi variabel dan pengaturan waktu permainan
        boolean tebakBerhasil = false;
        long startTime = System.currentTimeMillis();
        long duration = 60000; // Waktu permainan: 1 menit dalam milidetik (60.000 ms)
        int percobaan = 0;
        int randomNumber = random.nextInt(100) + 1; // Mengambil angka acak antara 1 hingga 100

        // Pesan selamat datang dan aturan permainan
        System.out.println("Selamat datang di Permainan Tebak Angka!");
        System.out.println("Angka telah dipilih secara acak antara 1 hingga 100.");
        System.out.println("Anda memiliki 1 menit untuk menebak angka tersebut.");

        // Loop permainan utama
        while (!tebakBerhasil && (System.currentTimeMillis() - startTime < duration)) {
            System.out.print("\nMulai tebak angka: ");
            int angka = input.nextInt();
            percobaan++;

            // Membandingkan tebakan pengguna dengan angka acak
            if (angka == randomNumber) {
                System.out.println("Selamat, tebakan Anda benar!");
                System.out.println("Anda berhasil menebak angka " + randomNumber + " dalam " + percobaan + " kali percobaan.");
                tebakBerhasil = true;
            } else if (angka < randomNumber) {
                System.out.println("Tebakan terlalu rendah. Coba lagi!");
            } else {
                System.out.println("Tebakan terlalu tinggi. Coba lagi!");
            }
        }

        // Pesan hasil permainan jika waktu habis
        if (!tebakBerhasil) {
            System.out.println("Waktu habis. Permainan berakhir.");
        }

        // Pesan penutup
        System.out.println("Terima kasih telah bermain. Sampai Jumpa!");
        // Menutup Scanner
        input.close();

    }
}