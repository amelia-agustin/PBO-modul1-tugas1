import javax.xml.namespace.QName;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Mahasiswaa data = new Mahasiswaa();
        int pilih;
        Scanner inputp = new Scanner(System.in);

            do {
                System.out.print("Menu: \n1. Tambahkan data mahasiswa \n2. Tampilkan data mahasiswa \n3. Keluar\n");
                System.out.print("Pilihan anda: ");
                pilih = inputp.nextInt();
                if (pilih == 1) {
                    data.tampildatamahasiswa();
                } else if (pilih == 2) {
                    System.out.println("Data mahasiswa: ");
                    System.out.println(Mahasiswaa.tampilUniversitas(" Muhammadiyah malang"));
                    System.out.println("Nama: " + data.nama + ", NIM: " + data.NIM + ", Jurusan: " + data.jurusan);
                } else {
                    System.out.println("Adios");
                    return;
                }
            } while (pilih == 1 || pilih == 2 || pilih == 3);

        }

}