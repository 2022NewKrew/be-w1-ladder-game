package domain;

import java.util.List;

public class ConditionCheck {
    public static final int MAX_NAME_LENGTH = 5;
    public static final String ESCAPE_WORD = "춘식이";

    public static boolean elementLengthCheck(List<String> list) {
        return list.stream().allMatch(s -> s.length() <= MAX_NAME_LENGTH);
    }

    public static boolean isPositiveInteger(String number) {
        return number.chars().allMatch(Character::isDigit) && Integer.parseInt(number) > 0;
    }
}
