package ladder.domain;

import ladder.exception.InvalidHeight;
import ladder.exception.InvalidName;
import ladder.message.ErrorMessage;

import java.util.ArrayList;

public class Validation {
    private static final int MAX_NAME_LENGTH = 5;

    public static void validateHeight(int height) {
        condition(0 < height, new InvalidHeight(ErrorMessage.NEGATIVE_HEIGHT.getMessage()));
    }

    public static void validateNames(ArrayList<String> names) {
        condition(!names.isEmpty(), new InvalidName(ErrorMessage.EMPTY_NAMES.getMessage()));
        names.forEach(Validation::validateName);
    }

    private static void validateName(String name) {
        condition(!name.isEmpty(), new InvalidName(ErrorMessage.EMPTY_NAME.getMessage()));
        condition(name.length() <= MAX_NAME_LENGTH, new InvalidName(ErrorMessage.EXCEED_MAX_NAME.getMessage()));
    }

    private static void condition(boolean predicate, RuntimeException runtimeException) {
        if (!predicate)
            throw runtimeException;
    }
}
