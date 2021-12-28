package validator;

public class Validator {
    public static void checkPositiveInteger(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException();
        }
    }
}
