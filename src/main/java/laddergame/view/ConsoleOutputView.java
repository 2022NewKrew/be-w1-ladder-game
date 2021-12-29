package laddergame.view;

import laddergame.domain.Ladder;
import laddergame.domain.Line;
import laddergame.domain.Player;

import java.util.List;

public class ConsoleOutputView implements OutputView {
    private static final String PILLAR = "|";
    private static final String BRIDGE = "-----";
    private static final String NO_BRIDGE = "     ";
    private static final String BLANK = " ";
    private static final int MAX_NAME_LENGTH = 5;

    public void printLadderResult(List<Player> playerList, Ladder ladder) {
        printPlayerList(playerList);
        printLadder(ladder);
    }

    public void printPlayerList(List<Player> playerList) {
        StringBuilder stringBuilder = new StringBuilder(BLANK);
        for (Player player : playerList) {
            stringBuilder.append(BLANK)
                    .append(addLeftBlank(player.getName()))
                    .append(player.getName());
        }
        System.out.println(stringBuilder);
    }

    private String addLeftBlank(String name) {
        return BLANK.repeat(MAX_NAME_LENGTH - name.length());
    }

    private void printLadder(Ladder ladder) {
        List<Line> lineList = ladder.getLineList();
        for (Line line : lineList) {
            printLine(line);
        }
    }

    private void printLine(Line line) {
        StringBuilder stringBuilder = new StringBuilder(NO_BRIDGE + PILLAR);
        for (boolean isConnected : line.getConnectionList()) {
            stringBuilder.append(isConnected ? BRIDGE : NO_BRIDGE);
            stringBuilder.append(PILLAR);
        }
        System.out.println(stringBuilder);
    }
}
