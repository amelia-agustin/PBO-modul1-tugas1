import java.util.Scanner;
import java.util.InputMismatchException;
public class Main {
    String[][] bookList = {
            {"1234", "Harry Potter", "J.K. Rowling", "5"},
            {"5678", "Lord of the Rings", "J.R.R. Tolkien", "3"}
    };
    String[][] userStudent = {
            {"202310370311307", "Amelia Agustin", "Teknik", "Informatika"}
    };

   // Admin admin = new Admin();
    Admin admin;
    Student student;
    Scanner scanner = new Scanner(System.in);

    void menu() {
        System.out.println("=== Menu Login ===:");
        System.out.println("1. Masuk sebagai Mahasiswa");
        System.out.println("2. Masuk sebagai Admin");
        System.out.println("3. Keluar");
    }

    void inputNIM() {
        System.out.print("Masukkan NIM Anda: ");
        String inputNIM = scanner.next();
        checkNIM(inputNIM);
    }

    void checkNIM(String nim) {
        boolean found = false; //untuk ngecek
        for (String[] user : userStudent) { //untuk ngecek apakah nimnya sudah terdaftar atau tidak
            if (user[0].equals(nim)) {
                found = true;
                System.out.println("Login Mahasiswa Berhasil. Selamat datang, " + user[1] + "!");
                student = new Student(user[1], user[2], user[3]); //unutk ngisi method student dalam class student
                student.displayBooks(bookList); //memanggil class student
                menuStudent();
                return;
            }
        }
        if (!found)
            System.out.println("Mahasiswa Tidak Ditemukan.");
        menu();
    }

    void menuAdmin() {
        System.out.println("=== Dashboard Admin ===");
        System.out.println("1. Tambah Mahasiswa");
        System.out.println("2. Tampilkan Daftar Mahasiswa");
        System.out.println("3. Keluar");
        System.out.print("Pilih opsi (1-3): ");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                addStudent();
                break;
            case 2:
                admin.displayStudents(userStudent);
                menuAdmin();
                break;
            case 3:
                menu();
                break;
            default:
                System.out.println("Pilihan Tidak Valid.");
        }
    }

    void addStudent() {
        System.out.println("=== Menambahkan Mahasiswa ===");
        System.out.print("Masukkan Nama Mahasiswa: ");
        scanner.nextLine();
        String name = scanner.nextLine();
        System.out.print("Masukkan NIM Mahasiswa: ");
        String nim = scanner.next();
        System.out.print("Masukkan Fakultas Mahasiswa: ");
        String faculty = scanner.next();
        System.out.print("Masukkan Program Studi Mahasiswa: ");
        String studyProgram = scanner.next();

        admin.addStudent(userStudent, name, nim, faculty, studyProgram);

        menuAdmin();
    }

    void borrowBook() {
        System.out.println("=== Meminjam Buku ===");
        System.out.print("Masukkan ID Buku yang ingin dipinjam: ");
        String bookID = scanner.next();

        boolean bookFound = false; //untuk pengecekkan
        for (String[] book : bookList) {
            if (book[0].equals(bookID)) { //ngecek apakah book indeks ke.. sama seperti yg diinput (bookid)
                bookFound = true;
                int stock = Integer.parseInt(book[3]); //mengkonversi nilai yang semula berupa string menjadi integer pada booklist indeks ke 3
                if (stock > 0) {
                    System.out.println("Buku '" + book[1] + "' berhasil dipinjam.");
                    stock--;
                    book[3] = String.valueOf(stock); //dikonversi ke string dan disimpan lagi ke dalam arraynya
                    student.borrowedBookID = bookID;
                } else {
                    System.out.println("Maaf, stok buku tidak mencukupi.");
                }
                break;
            }
        }
        if (!bookFound) {
            System.out.println("Buku dengan ID tersebut tidak ditemukan.");
        }

        menuStudent();
    }

    void returnBook() {
        System.out.println("=== Melihat Buku yang Dipinjam ===");
        student.displayBorrowedBook(bookList);
        menuStudent();
    }

    void menuStudent() {
        System.out.println("=== Dashboard Mahasiswa ===");
        System.out.println("1. Pinjam Buku");
        System.out.println("2. Lihat Buku yang Dipinjam");
        System.out.println("3. Keluar");
        System.out.print("Pilih opsi (1-3): ");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                borrowBook();
                break;
            case 2:
                returnBook();
                break;
            case 3:
                student.logout();
                menu();
                break;
            default:
                System.out.println("Pilihan Tidak Valid.");
                menuStudent();
        }
    }


    void logout() {
        System.out.println("Terima kasih telah menggunakan program. Sampai jumpa!");
        scanner.close();
    }


    public static void main(String[] args) {
        Main main = new Main();
        boolean studentAddPermission = true;

        main.admin = new Admin(studentAddPermission);

        while (true) {
            main.menu();
            System.out.print("Pilih opsi (1-3): ");
            try { //digunakan untuk membaca input dari pengguna, jika input tidak valit maka akan terjadi kesalah dalam matc..
                int opsi = main.scanner.nextInt();

                switch (opsi) {
                    case 1:
                        System.out.println("Masuk sebagai Mahasiswa:");
                        main.inputNIM();
                        break;

                    case 2:
                        System.out.println("Masuk sebagai Admin:");
                        System.out.print("Masukkan username: ");
                        String inputUsername = main.scanner.next();
                        System.out.print("Masukkan password: ");
                        String inputPassword = main.scanner.next();

                        if (inputUsername.equals(main.admin.adminUsername) && inputPassword.equals(main.admin.password)) {
                            main.menuAdmin();
                        } else {
                            System.out.println("Admin Tidak Ditemukan.");
                            main.menu();
                        }
                        break;

                    case 3:
                        main.logout();
                        return;

                    default:
                        System.out.println("Pilihan Tidak Valid.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Masukkan harus berupa bilangan bulat.");
                main.scanner.next();
            } //try-cath digunakan untuk memastikan bahwa input yg dimasukkan merupakan bilangan bul. jika tidak maka akan ditampilkan masukka...
        }
    }


}
