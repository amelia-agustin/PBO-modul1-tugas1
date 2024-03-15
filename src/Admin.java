

public class Admin {
    String adminUsername = "admin";
    String password = "adm1n";
    boolean studentAddPermission;

    public Admin(boolean studentAddPermission) {
        this.studentAddPermission = studentAddPermission;
    } //ngecek a


    public void addStudent(String[][] userStudent, String name, String nim, String faculty, String studyProgram) {
        String[][] newUserStudent = new String[userStudent.length + 1][4];
        for (int i = 0; i < userStudent.length; i++) {
            newUserStudent[i] = userStudent[i];
        }
        newUserStudent[userStudent.length] = new String[]{nim, name, faculty, studyProgram};
        userStudent = newUserStudent;

        System.out.println("Mahasiswa berhasil ditambahkan.");
    }

    public void displayStudents(String[][] userStudent) {
        System.out.println("=== Daftar Mahasiswa ===");
        for (String[] student : userStudent) {
            System.out.println("NIM: " + student[0]);
            System.out.println("Nama: " + student[1]);
            System.out.println("Fakultas: " + student[2]);
            System.out.println("Program Studi: " + student[3]);
            System.out.println();
        }
    }


}
