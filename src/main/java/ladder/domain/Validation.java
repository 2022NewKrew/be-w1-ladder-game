package ladder.domain;

import ladder.exception.InvalidHeight;
import ladder.exception.InvalidName;

import java.util.ArrayList;

public class Validation {
    private static final int MAX_NAME_LENGTH = 5;

    public static void validateHeight(int height) {
        condition(0 < height, new InvalidHeight("사다리 높이는 양의 정수여야 합니다"));
    }

    public static void validateNames(ArrayList<String> names) {
        names.stream().forEachOrdered(Validation::validateName);
    }

    public static void validateName(String name) {
        condition(!name.isEmpty(), new InvalidName("사람 이름이 비었습니다"));
        condition(name.length() <= MAX_NAME_LENGTH, new InvalidName("이름 길이는 5자 미만이어야 합니다"));
    }

    private static void condition(boolean predicate, RuntimeException runtimeException) {
        if (!predicate)
            throw runtimeException;
    }
}
