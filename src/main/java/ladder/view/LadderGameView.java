package ladder.view;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import ladder.domain.LadderGame;
import ladder.domain.LadderLine;

public class LadderGameView {

    private static final String NAME_RESULT_DELIMITER = " ";
    private static final String NAME_RESULT_FORMAT = "%5s";
    private static final String LINE_START_BLANK = "    ";
    private static final String LADDER_BAR = "|";
    private static final String LADDER_CONNECT = "-----";
    private static final String LADDER_BLANK = "     ";
    private static final String GAME_RESULT_MESSAGE = String.format("%n%s%n", "사다리 결과");

    private static final int MAX_STRING_LENGTH = 5;

    public void showGameBoard(LadderGame ladderGame) {
        if (!ladderGame.isAvailable()) {
            throw new NullPointerException("사다리 게임이 정상적으로 생성된 상태가 아니에요.");
        }
        List<String> printBoard = new ArrayList<>();

        printBoard.add(GAME_RESULT_MESSAGE);
        printBoard.add(formatAndJoinStrings(ladderGame.getParticipantsNames()));
        ladderGame.getGameBoard().forEach(line -> printBoard.add(shapeLine(line)));
        printBoard.add(formatAndJoinStrings(ladderGame.getGameResults()));

        System.out.println(String.join(System.lineSeparator(), printBoard));
    }

    private String formatAndJoinStrings(List<String> values) {
        return NAME_RESULT_DELIMITER + values.stream()
            .map(this::formatString)
            .collect(Collectors.joining(NAME_RESULT_DELIMITER));
    }

    private String shapeLine(LadderLine line) {
        StringBuilder stringBuilder = new StringBuilder(LINE_START_BLANK);
        line.getLine()
            .forEach(connected -> stringBuilder.append(LADDER_BAR).append(connected ? LADDER_CONNECT
                : LADDER_BLANK));

        return stringBuilder.append(LADDER_BAR).toString();
    }

    private String formatString(String value) {
        return String.format(NAME_RESULT_FORMAT,
            value.length() <= MAX_STRING_LENGTH ? value : value.substring(0, MAX_STRING_LENGTH));
    }
}
