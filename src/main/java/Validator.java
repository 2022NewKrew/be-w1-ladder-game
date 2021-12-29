import java.util.List;

public class Validator {

    public static void checkHeight(int input) {
        if (input <= 0) {
            throw new IllegalArgumentException();
        }
    }
    public static void checkName(List<String> names) {
        if (names.size() <= 0) {
            throw new IllegalArgumentException();
        }
        for (String name : names) {
            checkNameLength(name);
        }
    }

    private static void checkNameLength(String name) {
        if (name.length()<=0 || name.length()>5) {
            throw new IllegalArgumentException();
        }
    }
}
