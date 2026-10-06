public class InputValidator {

    public static boolean isValidId(int id) {
        return id > 0;
    }

    public static boolean isValidMarks(double marks) {
        return marks >= 0 && marks <= 100;
    }

    public static boolean isValidText(String text) {
        return text != null && !text.trim().isEmpty();
    }
}