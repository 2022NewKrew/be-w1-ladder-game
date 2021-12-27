package main.java;

import java.util.Scanner;
import java.util.regex.Pattern;

public class InputView {
    private final static String MESSAGE_PLAYERS_NUM = "참여할 사람은 몇 명인가요?";
    private final static String MESSAGE_HEIGHT = "최대 사다리 높이는 몇 개인가요?";
    private final static String MESSAGE_CHECK_NUMERIC = "높이 값은 정수여야 합니다.";
    private final static String NUMERIC_REGEX = "^[-]?[0-9]+$";
    private final static Pattern PATTERN_NUMERIC = Pattern.compile(NUMERIC_REGEX);
    private final static Scanner scanner = new Scanner(System.in);

    private static int checkNumeric(String number) {
        number = number.trim();
        if (!PATTERN_NUMERIC.matcher(number).matches()) {
            throw new IllegalArgumentException(MESSAGE_CHECK_NUMERIC);
        }
        return Integer.parseInt(number);
    }

    public static int enterPlayers(){
        System.out.println(MESSAGE_PLAYERS_NUM);
        return checkNumeric(scanner.nextLine());
    }

    public static int enterHeight(){
        System.out.println();
        System.out.println(MESSAGE_HEIGHT);
        return checkNumeric(scanner.nextLine());
    }
}
