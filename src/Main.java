import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        StudentManager manager =
            new StudentManager();

        // Load saved student data
        manager.loadStudents();

        while (true) {

            System.out.println(
                "\n======================================"
            );

            System.out.println(
                "       STUDENT MANAGEMENT SYSTEM"
            );

            System.out.println(
                "======================================"
            );

            System.out.println(
                "1. Add Student"
            );

            System.out.println(
                "2. View Students"
            );

            System.out.println(
                "3. Search Student"
            );

            System.out.println(
                "4. Update Student"
            );

            System.out.println(
                "5. Delete Student"
            );

            System.out.println(
                "6. Student Statistics"
            );

            System.out.println(
                "7. Sort by Marks"
            );

            System.out.println(
                "8. Sort by Name"
            );

            System.out.println(
                "9. Exit"
            );

            System.out.println(
                "======================================"
            );

            System.out.print(
                "Enter your choice: "
            );

            int choice;

            try {

                choice = scanner.nextInt();

            } catch (Exception e) {

                System.out.println(
                    "Invalid input! Please enter a number."
                );

                scanner.nextLine();

                continue;
            }

            switch (choice) {

                // =========================
                // ADD STUDENT
                // =========================

                case 1:

                    System.out.print(
                        "Enter Student ID: "
                    );

                    int id;

                    try {

                        id = scanner.nextInt();

                    } catch (Exception e) {

                        System.out.println(
                            "Invalid ID. Please enter a number."
                        );

                        scanner.nextLine();

                        break;
                    }

                    if (!InputValidator.isValidId(id)) {

                        System.out.println(
                            "Student ID must be greater than 0."
                        );

                        break;
                    }

                    scanner.nextLine();

                    System.out.print(
                        "Enter Student Name: "
                    );

                    String name =
                        scanner.nextLine();

                    if (!InputValidator.isValidText(name)) {

                        System.out.println(
                            "Name cannot be empty."
                        );

                        break;
                    }

                    System.out.print(
                        "Enter Course: "
                    );

                    String course =
                        scanner.nextLine();

                    if (!InputValidator.isValidText(course)) {

                        System.out.println(
                            "Course cannot be empty."
                        );

                        break;
                    }

                    System.out.print(
                        "Enter Marks (0-100): "
                    );

                    double marks;

                    try {

                        marks =
                            scanner.nextDouble();

                    } catch (Exception e) {

                        System.out.println(
                            "Invalid marks."
                        );

                        scanner.nextLine();

                        break;
                    }

                    if (
                        !InputValidator.isValidMarks(marks)
                    ) {

                        System.out.println(
                            "Marks must be between 0 and 100."
                        );

                        break;
                    }

                    Student student =
                        new Student(
                            id,
                            name,
                            course,
                            marks
                        );

                    manager.addStudent(student);

                    break;


                // =========================
                // VIEW STUDENTS
                // =========================

                case 2:

                    manager.viewStudents();

                    break;


                // =========================
                // SEARCH STUDENT
                // =========================

                case 3:

                    System.out.print(
                        "Enter Student ID to search: "
                    );

                    int searchId;

                    try {

                        searchId =
                            scanner.nextInt();

                    } catch (Exception e) {

                        System.out.println(
                            "Invalid ID."
                        );

                        scanner.nextLine();

                        break;
                    }

                    manager.searchStudent(searchId);

                    break;


                // =========================
                // UPDATE STUDENT
                // =========================

                case 4:

                    System.out.print(
                        "Enter Student ID to update: "
                    );

                    int updateId;

                    try {

                        updateId =
                            scanner.nextInt();

                    } catch (Exception e) {

                        System.out.println(
                            "Invalid ID."
                        );

                        scanner.nextLine();

                        break;
                    }

                    scanner.nextLine();

                    System.out.print(
                        "Enter New Name: "
                    );

                    String newName =
                        scanner.nextLine();

                    if (!InputValidator.isValidText(newName)) {

                        System.out.println(
                            "Name cannot be empty."
                        );

                        break;
                    }

                    System.out.print(
                        "Enter New Course: "
                    );

                    String newCourse =
                        scanner.nextLine();

                    if (!InputValidator.isValidText(newCourse)) {

                        System.out.println(
                            "Course cannot be empty."
                        );

                        break;
                    }

                    System.out.print(
                        "Enter New Marks (0-100): "
                    );

                    double newMarks;

                    try {

                        newMarks =
                            scanner.nextDouble();

                    } catch (Exception e) {

                        System.out.println(
                            "Invalid marks."
                        );

                        scanner.nextLine();

                        break;
                    }

                    if (
                        !InputValidator.isValidMarks(newMarks)
                    ) {

                        System.out.println(
                            "Marks must be between 0 and 100."
                        );

                        break;
                    }

                    manager.updateStudent(
                        updateId,
                        newName,
                        newCourse,
                        newMarks
                    );

                    break;


                // =========================
                // DELETE STUDENT
                // =========================

                case 5:

                    System.out.print(
                        "Enter Student ID to delete: "
                    );

                    int deleteId;

                    try {

                        deleteId =
                            scanner.nextInt();

                    } catch (Exception e) {

                        System.out.println(
                            "Invalid ID."
                        );

                        scanner.nextLine();

                        break;
                    }

                    manager.deleteStudent(deleteId);

                    break;


                // =========================
                // STATISTICS
                // =========================

                case 6:

                    manager.showStatistics();

                    break;


                // =========================
                // SORT BY MARKS
                // =========================

                case 7:

                    manager.sortByMarks();

                    break;


                // =========================
                // SORT BY NAME
                // =========================

                case 8:

                    manager.sortByName();

                    break;


                // =========================
                // EXIT
                // =========================

                case 9:

                    FileManager.saveStudents(
                        manager.getStudents()
                    );

                    System.out.println(
                        "\nStudent data saved successfully."
                    );

                    System.out.println(
                        "Thank you for using "
                        + "Student Management System!"
                    );

                    scanner.close();

                    return;


                default:

                    System.out.println(
                        "Invalid choice!"
                    );
            }
        }
    }
}