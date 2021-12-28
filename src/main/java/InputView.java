package main.java;

import java.util.Scanner;
import java.util.regex.Pattern;

public class InputView {
    private final static String MESSAGE_PLAYERS_NUM = "참여할 사람은 몇 명인가요?";
    private final static String MESSAGE_HEIGHT = "최대 사다리 높이는 몇 개인가요?";
    private final static String MESSAGE_CHECK_NATURAL_NUMBER = "자연수를 입력해야 합니다.";
    private final static String NATURAL_NUMBER_REGEX = "[1-9][0-9]*$";
    private final static Pattern PATTERN_NATURAL_NUMBER = Pattern.compile(NATURAL_NUMBER_REGEX);
    private final static Scanner scanner = new Scanner(System.in);

    private static int checkNaturalNumber(String number) {
        number = number.trim();
        if (!PATTERN_NATURAL_NUMBER.matcher(number).matches()) {
            throw new IllegalArgumentException(MESSAGE_CHECK_NATURAL_NUMBER);
        }
        return Integer.parseInt(number);
    }

    public static int enterPlayers(){
        System.out.println(MESSAGE_PLAYERS_NUM);
        return checkNaturalNumber(scanner.nextLine());
    }

    public static int enterHeight(){
        System.out.println(MESSAGE_HEIGHT);
        return checkNaturalNumber(scanner.nextLine());
    }
}
