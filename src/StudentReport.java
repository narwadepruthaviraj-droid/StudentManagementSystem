import java.util.ArrayList;

public class StudentReport {

    public static void showStatistics(
            ArrayList<Student> students) {

        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }

        double total = 0;
        double highest = students.get(0).getMarks();
        double lowest = students.get(0).getMarks();

        String highestStudent = students.get(0).getName();
        String lowestStudent = students.get(0).getName();

        for (Student student : students) {

            double marks = student.getMarks();
            total += marks;

            if (marks > highest) {
                highest = marks;
                highestStudent = student.getName();
            }

            if (marks < lowest) {
                lowest = marks;
                lowestStudent = student.getName();
            }
        }

        double average = total / students.size();

        System.out.println("\n======= STUDENT REPORT =======");
        System.out.println("Total Students : " + students.size());
        System.out.println("Average Marks  : " + average);
        System.out.println("Highest Marks  : " + highest);
        System.out.println("Top Student    : " + highestStudent);
        System.out.println("Lowest Marks   : " + lowest);
        System.out.println("Lowest Student : " + lowestStudent);
    }
}