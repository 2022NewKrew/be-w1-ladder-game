package ladder;

import connector.Connector;
import line.Line;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    public static final String LADDER_LINE = "|";
    public static final String LADDER_EMPTY = "     ";
    public static final String LADDER_EXIST = "-----";

    private final int height;
    private final Connector connector;
    private final List<Line> lines = new ArrayList<>();

    public Ladder(String[] players, int height, Connector connector) {
        this.height = height;
        this.connector = connector;
        for (int i = 0; i < players.length; i++) {
            lines.add(new Line(players[i], height));
        }
    }

    public void make() {
        for (int i = 0; i < lines.size() - 1; i++) {
            connector.connectLine(lines.get(i), lines.get(i + 1));
        }
    }

    public void print() {
        StringBuilder sb = new StringBuilder();
        appendPlayerNames(sb);
        for (int i = 0; i < height; i++) {
            appendLadderRow(sb, i);
        }
        System.out.println(sb);
    }

    private void appendPlayerNames(StringBuilder sb) {
        sb.append("\t");
        for (int j = 0; j < lines.size(); j++) {
            sb.append(String.format("%-6s", lines.get(j).getName()));
        }
        sb.append("\n");
    }

    private void appendLadderRow(StringBuilder sb, int position) {
        sb.append("\t").append(LADDER_LINE);
        for (int i = 0; i < lines.size() - 1; i++) {
            String status = connector.isConnected(lines.get(i), lines.get(i + 1), position) ? LADDER_EXIST : LADDER_EMPTY;
            sb.append(status).append(LADDER_LINE);
        }
        sb.append("\n");
    }
}
