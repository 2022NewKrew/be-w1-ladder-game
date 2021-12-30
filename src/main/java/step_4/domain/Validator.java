package step_4.domain;

import java.util.Arrays;

public class Validator {
    public static void checkPositiveInteger(int input, String message) {
        if (input <= 0)
            throw new IllegalArgumentException(message);
    }

    public static void checkNameLength(String[] names, int maxNameLength, String message) {
        if (Arrays.stream(names).anyMatch(name -> name.length() > maxNameLength))
            throw new IllegalArgumentException(message);
    }
}
