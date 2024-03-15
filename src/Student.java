import java.util.InputMismatchException;
import java.util.Scanner;
public class Student {
    public String name;
    public String faculty;
    public String studyProgram;
    public String borrowedBookID;

    public Student(String name, String faculty, String studyProgram) {
        this.name = name;
        this.faculty = faculty;
        this.studyProgram = studyProgram;
    }

    public void logout() {
        System.out.println("Logging out...");
    }

    public void displayBooks(String[][] bookList) {
        System.out.println("=== Daftar Buku ===");
        System.out.printf("| %-5s | %-20s | %-20s | %-5s |\n", "ID", "Judul", "Penulis", "Stok"); //format untuk membuat tabel dengan ukuran dan batas yg sesuai
        for (String[] book : bookList) {
            System.out.printf("| %-5s | %-20s | %-20s | %-5s |\n", book[0], book[1], book[2], book[3]);
        }
    }

    public void displayBorrowedBook(String[][] bookList) {
        System.out.println("=== Buku yang Dipinjam ===");
        System.out.printf("| %-5s | %-20s | %-20s |\n", "ID", "Judul", "Penulis");
        for (String[] book : bookList) {
            if (book[0].equals(borrowedBookID)) {
                System.out.printf("| %-5s | %-20s | %-20s |\n", book[0], book[1], book[2]);
                break;
            }
        }
    }

}
