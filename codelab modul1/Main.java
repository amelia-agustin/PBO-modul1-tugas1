package org.example;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        String nama;
        String jk;
        String tanggalLahir;
        Scanner objInput = new Scanner(System.in);

        System.out.print("Nama: ");
        nama    = objInput.nextLine();
        System.out.print("Jenis Kelamin (L/P): ");
        jk  = objInput.nextLine();
        System.out.print("Tanggal Lahir (yyy-mm-dd): ");
        tanggalLahir = objInput.nextLine();

        //membuat objek untuk format tertentu (membuat format untuk tahun,bulan,tgl)
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyy-MM-dd");
        //ubah string menjadi local date
        LocalDate tgl = LocalDate.parse(tanggalLahir,format);
        //menentukan tanggal hari ini untuk perbandingan sebagai periode
        LocalDate   today = LocalDate.now();
        //hitung selisih tanggal lahir dengan hari ini menggunakan Period
        Period selisih = Period.between(tgl,today);
        //mengubah umur dalam bentuk tahun
        int umur = selisih.getYears(); //getyears untuk bentuk tahun, selisih dari variabel selisih
        int umurBulan = selisih.getMonths(); //ubah dalam bentuk bulan

        System.out.println("\n\n\n//output");
        System.out.println("Nama: "+nama);
        switch (jk) {
            case "L":
                System.out.println("Jenis Kelamin: Laki-Laki");
                break;
            case "P":
                System.out.println("Jenis Kelamin: Perempuan");
                break;
            default:
                System.out.println("Ketikkan huruf besar (L/P)");
        }
        System.out.println("Umur Anda: " +umur+" tahun " +umurBulan+ " bulan ");




    }
}