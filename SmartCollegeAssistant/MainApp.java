import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice = 0;   // ✅ FIX: initialized

        do {
            System.out.println("\n1.Add Student 2.View Students 3.Update 4.Delete 5.Exit");

            // 👉 Safe input
            if (sc.hasNextInt()) {
                choice = sc.nextInt();
            } else {
                System.out.println("Enter valid number!");
                sc.next(); // clear wrong input
                continue;
            }

            switch (choice) {

                // 👉 ADD STUDENT
                case 1:
                    System.out.print("Enter name: ");
                    String name = sc.next();

                    System.out.print("Enter id: ");
                    int id = sc.nextInt();

                    Student s = new Student(name, id);
                    FileHandler.saveStudent(s);

                    System.out.println("Student Saved");
                    break;

                // 👉 VIEW STUDENTS
                case 2:
                    String data = FileHandler.readStudents();
                    System.out.println("\n--- Student List ---");
                    System.out.println(data);
                    break;

                // 👉 UPDATE STUDENT
                case 3:
                    System.out.print("Enter ID to update: ");
                    String uid = sc.next();

                    System.out.print("Enter new name: ");
                    String newName = sc.next();

                    FileHandler.updateStudent(uid, newName);
                    System.out.println("Student Updated");
                    break;

                // 👉 DELETE STUDENT
                case 4:
                    System.out.print("Enter ID to delete: ");
                    String did = sc.next();

                    FileHandler.deleteStudent(did);
                    System.out.println("Student Deleted");
                    break;

                // 👉 EXIT
                case 5:
                    System.out.println("Exit");
                    break;

                default:
                    System.out.println("Invalid Choice");
            }

        } while (choice != 5);

        sc.close();
    }
}