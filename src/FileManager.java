import java.io.*;
import java.util.ArrayList;

public class FileManager {

    private static final String FILE_NAME =
        "students.txt";

    // Save students
    public static void saveStudents(
            ArrayList<Student> students) {

        try (
            BufferedWriter writer =
                new BufferedWriter(
                    new FileWriter(FILE_NAME)
                )
        ) {

            for (Student student : students) {

                writer.write(
                    student.getId()
                    + "|"
                    + student.getName()
                    + "|"
                    + student.getCourse()
                    + "|"
                    + student.getMarks()
                );

                writer.newLine();
            }

        } catch (IOException e) {

            System.out.println(
                "Error saving data: "
                + e.getMessage()
            );
        }
    }

    // Load students
    public static ArrayList<Student> loadStudents() {

        ArrayList<Student> students =
            new ArrayList<>();

        File file =
            new File(FILE_NAME);

        if (!file.exists()) {

            return students;
        }

        try (
            BufferedReader reader =
                new BufferedReader(
                    new FileReader(FILE_NAME)
                )
        ) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data =
                    line.split("\\|");

                if (data.length == 4) {

                    try {

                        int id =
                            Integer.parseInt(data[0]);

                        String name =
                            data[1];

                        String course =
                            data[2];

                        double marks =
                            Double.parseDouble(data[3]);

                        students.add(
                            new Student(
                                id,
                                name,
                                course,
                                marks
                            )
                        );

                    } catch (NumberFormatException e) {

                        System.out.println(
                            "Invalid data skipped."
                        );
                    }
                }
            }

        } catch (IOException e) {

            System.out.println(
                "Error loading data: "
                + e.getMessage()
            );
        }

        return students;
    }
}