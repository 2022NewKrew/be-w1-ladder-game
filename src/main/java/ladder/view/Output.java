package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.Line;
import ladder.domain.Player;

import java.util.List;

public class Output {

    private static final String VERTICAL_BAR = "|";
    private static final String HORIZONTAL_BAR = "-";
    private static final String EMPTY_BAR = " ";
    private static final int LADDER_WIDTH = 5;
    private static final int NAME_GAP = 1;
    private static final String NEWLINE = "\n";
    private static final String BLANK = "    ";

    private Output() {};

    public static void printPlayerList(Ladder ladder) {
        StringBuilder sb = new StringBuilder();
        List<Player> playerList = ladder.getPlayerList();
        for (Player player : playerList) {
            sb.append(player.getNameWithGap(LADDER_WIDTH, NAME_GAP));
        }
        System.out.println(sb);
    }

    public static void printLadder(Ladder ladder) {
        StringBuilder sb = new StringBuilder();
        List<Line> lineList = ladder.getLineList();
        for (Line line : lineList) {
            sb.append(lineToString(line));
            sb.append(NEWLINE);
        }
        System.out.println(sb);
    }

    private static String lineToString(Line line) {
        StringBuilder sb = new StringBuilder();
        sb.append(BLANK);
        for (int i = 0; i < line.getLineSize(); i++) {
            sb.append(pointToString(line, i));
        }
        return sb.toString();
    }

    private static String pointToString(Line line, int index) {
        if (line.isVertical(index)) return VERTICAL_BAR;
        if (line.isConnected(index)) {
            return HORIZONTAL_BAR.repeat(LADDER_WIDTH);
        }
        return EMPTY_BAR.repeat(LADDER_WIDTH);
    }
}