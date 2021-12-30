package main.view;

import main.domain.ladder.Ladder;

public class LadderPrinter {

    public static final String LADDER_LINE = "|";
    public static final String LADDER_EMPTY = "     ";
    public static final String LADDER_EXIST = "-----";

    private final Ladder ladder;

    public LadderPrinter(Ladder ladder) {
        this.ladder = ladder;
    }

    public void print() {
        StringBuilder sb = new StringBuilder();
        appendPlayerNames(sb);
        for (int i = 0; i < ladder.getHeight(); i++) {
            appendLadderRow(sb, i);
        }
        appendResults(sb);
        System.out.println(sb);
    }

    private void appendPlayerNames(StringBuilder sb) {
        sb.append("\t");
        for (int i = 0; i < ladder.getWidth(); i++) {
            sb.append(String.format("%-6s", ladder.getLine(i).getName()));
        }
        sb.append("\n");
    }

    private void appendLadderRow(StringBuilder sb, int position) {
        sb.append("\t").append(LADDER_LINE);
        for (int i = 0; i < ladder.getWidth() - 1; i++) {
            String status = ladder.getLine(i).isConnectedTo(ladder.getLine(i + 1), position) ? LADDER_EXIST : LADDER_EMPTY;
            sb.append(status).append(LADDER_LINE);
        }
        sb.append("\n");
    }

    private void appendResults(StringBuilder sb) {
        sb.append("\t");
        for (int i = 0; i < ladder.getWidth(); i++) {
            sb.append(String.format("%-6s", ladder.getLine(i).getResult()));
        }
        sb.append("\n");
    }
}
