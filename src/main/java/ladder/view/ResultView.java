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
     * 사다리타기의 맨 윗줄 이름을 출력하는 메서드
     *
     * @param names 출력할 이름 리스트
     */
    public static void printNameOrResult(ArrayList<String> names) {
        System.out.printf("%6s", names.get(0));
        for (int i = 1; i < names.size(); i++) {
            System.out.printf("%6s", names.get(i));
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
