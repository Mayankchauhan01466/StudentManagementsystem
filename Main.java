import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        StudentService service = new StudentService();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");

            System.out.print("Choose option: ");
            if (!sc.hasNextInt()) {
                System.out.println("❌ Invalid input. Please enter a number.");
                sc.next(); // Consume invalid input
                continue;
            }
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("ID: ");
                    while (!sc.hasNextInt()) {
                        System.out.println("❌ Invalid ID. Please enter a number.");
                        sc.next(); // Consume invalid input
                        System.out.print("ID: ");
                    }
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Name: ");
                    String name = sc.nextLine();

                    System.out.print("Age: ");
                    while (!sc.hasNextInt()) {
                        System.out.println("❌ Invalid Age. Please enter a number.");
                        sc.next(); // Consume invalid input
                        System.out.print("Age: ");
                    }
                    int age = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Course: ");
                    String course = sc.nextLine();

                    service.addStudent(new Student(id, name, age, course));
                    break;

                case 2:
                    service.viewStudents();
                    break;

                case 3:
                    System.out.print("Enter ID: ");
                    int searchId = sc.nextInt();
                    Student s = service.searchById(searchId);
                    if (s != null) {
                        System.out.println("Found: " + s.getName());
                    } else {
                        System.out.println("❌ Not found");
                    }
                    break;

                case 4:
                    System.out.print("Enter ID: ");
                    int delId = sc.nextInt();
                    service.deleteStudent(delId);
                    break;

                case 5:
                    System.out.println("👋 Exiting...");
                    return;

                default:
                    System.out.println("❌ Invalid choice");
            }
        }
    }
}








