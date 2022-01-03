package ladder.view;

import ladder.domain.Line;
import ladder.message.GameMessage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.stream.Stream;

public class ResultView {
    private static final int RUNG_LENGTH = 5;
    private static final String SIDE_RAIL = "|";
    private static final String RUNG = "-".repeat(RUNG_LENGTH);
    private static final String SPACE = " ".repeat(RUNG_LENGTH);

    public static void printGameResultMessage() {
        System.out.println(GameMessage.GAME_RESULT.getMessage());
    }

    public static void printEndGameMessage() {
        System.out.println(GameMessage.END_GAME.getMessage());
    }

    /**
     * 사다리의 한 줄을 출력하는 메서드
     *
     * @param line 출력할 한 줄
     */
    private static void printLine(List<Boolean> line) {
        System.out.printf("%s%s", SPACE, SIDE_RAIL);

        for (Boolean point : line) {
            System.out.print(point ? RUNG : SPACE);
            System.out.print(SIDE_RAIL);
        }
    }

    /**
     * 사다리를 출력하는 메서드
     *
     * @param lines 출력할 줄 리스트
     */
    public static void printLadder(List<Line> lines) {
        for (Line line : lines) {
            printLine(line.getLine());
            System.out.println();
        }
    }

    /**
     * 이름 사이의 공백을 출력하는 메서드
     *
     * @param beforeName 공백 이전 이름
     * @param afterName  공백 이후 이름
     */
    private static void printSpaceBetweenNames(String beforeName, String afterName) {
        int beforeNameLength = beforeName.length() == 0 ? 0 : (beforeName.length() + 1) / 2 - 1;
        int afterNameLength = afterName.length() / 2;
        int spaceCount = SPACE.length() - beforeNameLength - afterNameLength;

        Stream.generate(() -> " ")
                .limit(spaceCount)
                .forEach(System.out::print);
    }

    /**
     * 사다리타기의 맨 윗줄 이름을 출력하는 메서드
     *
     * @param names 출력할 이름 리스트
     */
    public static void printNameOrResult(ArrayList<String> names) {
        printSpaceBetweenNames("", names.get(0));
        System.out.printf("%s", names.get(0));
        for (int i = 1; i < names.size(); i++) {
            printSpaceBetweenNames(names.get(i - 1), names.get(i));
            System.out.printf("%s", names.get(i));
        }
        System.out.println();
    }

    public static void printPlayerResults(HashMap<String, String> playerResults) {
        for (Entry result : playerResults.entrySet()) {
            System.out.println(result.getKey() + " : " + result.getValue());
        }
    }

    public static void printPlayerResult(String result) {
        System.out.println(GameMessage.RESULT_OF_PLAYER.getMessage());
        System.out.println(result);
    }
}
