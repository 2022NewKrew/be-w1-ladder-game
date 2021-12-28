package step_2;

public class Validator {
    public void checkPositiveInteger(int input, String message) {
        if (input <= 0)
            throw new IllegalArgumentException(message);
    }
}
