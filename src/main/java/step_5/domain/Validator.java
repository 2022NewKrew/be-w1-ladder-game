package step_5.domain;

import step_5.dto.LadderInfo;

import java.util.Arrays;
import java.util.Objects;

public class Validator {
    public static void checkPositiveInteger(int input, String message) {
        if (input <= 0)
            throw new IllegalArgumentException(message);
    }

    public static void checkNameLength(String[] names, int maxNameLength, String message) {
        if (Arrays.stream(names).anyMatch(name -> (name.length() > maxNameLength || name.length() < 1)))
            throw new IllegalArgumentException(message);
    }

    public static void checkNameInNames(LadderInfo ladderInfo, String inputName, String finisher, String message) {
        if (!inputName.equals(finisher) && !inputName.equals("all") && Arrays.stream(ladderInfo.getNames()).noneMatch(name -> name.equals(inputName)))
            throw new IllegalArgumentException(message);
    }

    public static void checkNotMatched(String[] names, String[] results, String message) {
        if (names.length != results.length)
            throw new IllegalArgumentException(message);
    }
}
