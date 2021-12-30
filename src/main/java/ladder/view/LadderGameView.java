package ladder.view;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import ladder.domain.LadderGame;
import ladder.domain.LadderLine;

public class LadderGameView {

    private static final String NAME_DELIMITER = " ";
    private static final String LINE_START_BLANK = "    ";
    private static final String NAME_FORMAT_PATTERN = "%5s";
    private static final String BAR = "|";
    private static final String CONNECT = "-----";
    private static final String BLANK = "     ";

    private static final int MAX_NAME_LENGTH = 5;

    public void showGameBoard(LadderGame ladderGame) {
        List<String> printBoard = new ArrayList<>();
        printBoard.add(NAME_DELIMITER + ladderGame.getParticipantsNames().stream()
            .map(this::formatName)
            .collect(Collectors.joining(NAME_DELIMITER)));
        ladderGame.getGameBoard().forEach(line -> printBoard.add(shapeLine(line)));

        System.out.println(String.join(System.lineSeparator(), printBoard));
    }

    private String shapeLine(LadderLine line) {
        StringBuilder stringBuilder = new StringBuilder(LINE_START_BLANK);
        line.getLine()
            .forEach(connected -> stringBuilder.append(BAR).append(connected ? CONNECT : BLANK));

        return stringBuilder.append(BAR).toString();
    }

    private String formatName(String name) {
        return String.format(NAME_FORMAT_PATTERN,
            name.length() <= MAX_NAME_LENGTH ? name : name.substring(0, MAX_NAME_LENGTH));
    }
}
