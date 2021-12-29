package laddergame.view;

import laddergame.domain.Ladder;
import laddergame.domain.Line;

import java.util.List;

public class ConsoleOutputView implements OutputView {
    private static final String PILLAR = "|";
    private static final String BRIDGE = "-----";
    private static final String BLANK = "     ";

    public void printLadder(Ladder ladder) {
        List<Line> lineList = ladder.getLineList();
        for (Line line : lineList) {
            printLine(line);
        }
    }

    private void printLine(Line line) {
        StringBuilder stringBuilder = new StringBuilder(PILLAR);
        for (boolean isConnected : line.getConnectionList()) {
            stringBuilder.append(isConnected ? BRIDGE : BLANK);
            stringBuilder.append(PILLAR);
        }
        System.out.println(stringBuilder);
    }
}
