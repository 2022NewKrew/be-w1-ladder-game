package laddergame.view;

import laddergame.domain.Ladder;
import laddergame.domain.Line;

import java.util.List;

public class OutputView {
    private static final String PILLAR = "|";
    private static final String BRIDGE = "-----";
    private static final String BLANK = "     ";

    public static void printLadder(Ladder ladder) {
        List<Line> lineList = ladder.getLineList();
        for (Line line : lineList) {
            printLine(line);
        }
    }

    public static void printLine(Line line) {
        StringBuilder stringBuilder = new StringBuilder(PILLAR);
        for (boolean isConnected : line.getConnectionList()) {
            stringBuilder.append(isConnected ? BRIDGE : BLANK);
            stringBuilder.append(PILLAR);
        }
        System.out.println(stringBuilder);
    }
}
