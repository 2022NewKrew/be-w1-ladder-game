package step_2;

public class Validator {
    public static void checkPositiveInteger(int input, String message) {
        if (input <= 0)
            throw new IllegalArgumentException(message);
    }
}
