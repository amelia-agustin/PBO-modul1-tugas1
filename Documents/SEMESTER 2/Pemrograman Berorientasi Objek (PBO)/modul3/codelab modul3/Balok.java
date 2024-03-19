import java.util.Scanner;

public class Balok extends BangunRuang{
    private double panjang;
    private double lebar;
    private double tinggi;
    Scanner scanner = new Scanner(System.in);
    Balok(String namee){
        super(namee);
    }

    @Override
    public void inputNilai(){
        super.inputNilai();
        System.out.print("Input panjang: ");
        this.panjang = scanner.nextDouble();
        System.out.print("Input lebar: ");
        this.lebar = scanner.nextDouble();
        System.out.print("Input tinggi: ");
        this.tinggi = scanner.nextDouble();
    }

    @Override
    public void luasPermukaan(){
        super.luasPermukaan();
        double hasil = 2 * (panjang*lebar) + (panjang*tinggi);
        System.out.println("Hasil luas permukaan: " + hasil);
    }

    @Override
    public void volume(){
        super.volume();
        double hasil = panjang * lebar * tinggi;
        System.out.println("Hasil volume: " + hasil);
    }
}
