package ladder;

import connector.Connector;
import line.Line;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    public static final char LADDER_LINE = '|';
    public static final char LADDER_EMPTY = ' ';
    public static final char LADDER_EXIST = '-';

    private final int height;
    private final Connector connector;
    private final List<Line> lines = new ArrayList<>();

    public Ladder(int numOfPlayer, int height, Connector connector) {
        this.height = height;
        this.connector = connector;
        for (int i = 0; i < numOfPlayer; i++) {
            lines.add(new Line(i, height));
        }
    }

    public void make() {
        for (int i = 0; i < lines.size() - 1; i++) {
            connector.connectLine(lines.get(i), lines.get(i + 1));
        }
    }

    public void print() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < height; i++) {
            appendLadderRow(sb, i);
        }
        System.out.println(sb);
    }

    private void appendLadderRow(StringBuilder sb, int i) {
        sb.append("\n").append(LADDER_LINE);
        for (int k = 0; k < lines.size() - 1; k++) {
            char status = connector.isConnected(lines.get(k), lines.get(k + 1), i) ? LADDER_EXIST : LADDER_EMPTY;
            sb.append(status).append(LADDER_LINE);
        }
    }
}
