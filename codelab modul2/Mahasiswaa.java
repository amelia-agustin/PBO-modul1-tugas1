import java.util.Scanner;
public class Mahasiswaa {
    String nama,NIM,jurusan;
        static String tampilUniversitas(String universiti){
            return "universitas" + universiti;
        }
        String tampildatamahasiswa(){

            Scanner input = new Scanner(System.in);

            System.out.print("masukkan nama mahasiswa: ");
            nama = input.nextLine();
            System.out.print("masukkan NIM mahasiswa: ");
            NIM = input.nextLine();

            if (NIM.length() == 15){
                System.out.print("masukkan jurusan mahasiswa: ");
                jurusan = input.nextLine();
                System.out.println("Data mahasiswa berhasil ditambahkan.");
            } else {
                System.out.println("Nim harus 15 digit!!!");
                System.out.print("masukkan NIM mahasiswa: ");
                NIM = input.nextLine();
                System.out.print("masukkan jurusan mahasiswa: ");
                jurusan = input.nextLine();
                System.out.println("Data mahasiswa berhasil ditambahkan.");
            }
            return "nama";
        }
    String cetak (){
        System.out.println(nama);
        return nama;
    }

}
