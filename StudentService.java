import java.util.ArrayList;

public class StudentService {

    private ArrayList<Student> students = new ArrayList<>();

    public void addStudent(Student s) {
        students.add(s);
        System.out.println("✅ Student added successfully");
    }

    public void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("❌ No students found");
            return;
        }

        for (Student s : students) {
            System.out.println(
                s.getId() + " | " +
                s.getName() + " | " +
                s.getAge() + " | " +
                s.getCourse()
            );
        }
    }

    public Student searchById(int id) {
        for (Student s : students) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null;
    }

    public void deleteStudent(int id) {
        Student s = searchById(id);
        if (s != null) {
            students.remove(s);
            System.out.println("🗑 Student deleted");
        } else {
            System.out.println("❌ Student not found");
        }
    }
}

