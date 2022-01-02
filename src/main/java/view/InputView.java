package main.java.view;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public class InputView {
    private static final String MESSAGE_PLAYERS = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String DELIMITER_COMMA = ",";
    private static final String MESSAGE_EXECUTION_RESULTS = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String MESSAGE_HEIGHT = "최대 사다리 높이는 몇 개인가요?";
    private static final String MESSAGE_CHECK_NATURAL_NUMBER = "자연수를 입력해야 합니다.";
    private static final String NATURAL_NUMBER_REGEX = "[1-9][0-9]*$";
    private static final Pattern PATTERN_NATURAL_NUMBER = Pattern.compile(NATURAL_NUMBER_REGEX);
    private static final Scanner scanner = new Scanner(System.in);
    private static final String MESSAGE_PLAYER_YOU_WANT = "결과를 보고 싶은 사람은?";

    private InputView() {}

    private static int checkNaturalNumber(String number) {
        number = number.trim();
        if (!PATTERN_NATURAL_NUMBER.matcher(number).matches()) {
            throw new IllegalArgumentException(MESSAGE_CHECK_NATURAL_NUMBER);
        }
        return Integer.parseInt(number);
    }

    public static String[] enterPlayers() {
        System.out.println(MESSAGE_PLAYERS);
        String[] players = scanner.nextLine().split(DELIMITER_COMMA);
        players = Arrays.stream(players)
                .map(String::trim)
                .toArray(String[]::new);
        return players;
    }

    public static String[] enterExecutionResults(){
        System.out.println();
        System.out.println(MESSAGE_EXECUTION_RESULTS);
        String[] results = scanner.nextLine().split(DELIMITER_COMMA);
        results = Arrays.stream(results)
                .map(String::trim)
                .toArray(String[]::new);
        return results;
    }

    public static int enterHeight() {
        System.out.println(MESSAGE_HEIGHT);
        return checkNaturalNumber(scanner.nextLine());
    }

    public static String enterPlayerYouWant(){
        System.out.println();
        System.out.println(MESSAGE_PLAYER_YOU_WANT);
        return scanner.nextLine();
    }
}
