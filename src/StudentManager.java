import java.util.ArrayList;
import java.util.Comparator;

public class StudentManager {

    private ArrayList<Student> students = new ArrayList<>();

    // Add Student
    public boolean addStudent(Student student) {

        for (Student existing : students) {

            if (existing.getId() == student.getId()) {

                System.out.println(
                    "Student ID already exists!"
                );

                return false;
            }
        }

        students.add(student);

        System.out.println(
            "Student added successfully!"
        );

        return true;
    }

    // View Students
    public void viewStudents() {

        if (students.isEmpty()) {

            System.out.println(
                "No students found."
            );

            return;
        }

        System.out.println(
            "\n========== STUDENT LIST =========="
        );

        for (Student student : students) {

            System.out.println(
                "----------------------------------"
            );

            student.displayStudent();
        }

        System.out.println(
            "----------------------------------"
        );
    }

    // Search Student
    public void searchStudent(int id) {

        for (Student student : students) {

            if (student.getId() == id) {

                System.out.println(
                    "\nStudent found!"
                );

                System.out.println(
                    "----------------------------------"
                );

                student.displayStudent();

                return;
            }
        }

        System.out.println(
            "Student not found."
        );
    }

    // Update Student
    public void updateStudent(
            int id,
            String name,
            String course,
            double marks) {

        for (Student student : students) {

            if (student.getId() == id) {

                student.setName(name);
                student.setCourse(course);
                student.setMarks(marks);

                System.out.println(
                    "Student updated successfully!"
                );

                return;
            }
        }

        System.out.println(
            "Student not found."
        );
    }

    // Delete Student
    public void deleteStudent(int id) {

        for (int i = 0; i < students.size(); i++) {

            if (students.get(i).getId() == id) {

                students.remove(i);

                System.out.println(
                    "Student deleted successfully!"
                );

                return;
            }
        }

        System.out.println(
            "Student not found."
        );
    }

    // Student Statistics
    public void showStatistics() {

        StudentReport.showStatistics(students);
    }

    // Sort by Marks
    public void sortByMarks() {

        if (students.isEmpty()) {

            System.out.println(
                "No students available."
            );

            return;
        }

        students.sort(
            Comparator.comparingDouble(
                Student::getMarks
            ).reversed()
        );

        System.out.println(
            "Students sorted by marks successfully!"
        );
    }

    // Sort by Name
    public void sortByName() {

        if (students.isEmpty()) {

            System.out.println(
                "No students available."
            );

            return;
        }

        students.sort(
            Comparator.comparing(
                Student::getName,
                String.CASE_INSENSITIVE_ORDER
            )
        );

        System.out.println(
            "Students sorted by name successfully!"
        );
    }

    // Get all students
    public ArrayList<Student> getStudents() {

        return students;
    }

    // Load students from file
    public void loadStudents() {

        students = FileManager.loadStudents();

        if (!students.isEmpty()) {

            System.out.println(
                students.size()
                + " student(s) loaded from file."
            );
        }
    }
}