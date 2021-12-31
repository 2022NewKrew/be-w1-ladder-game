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

    public void printLadder() {
        printPlayerNames();
        printLadderContent();
        printLadderResults();
    }

    private void printPlayerNames() {
        StringBuilder sb = new StringBuilder();
        sb.append("\t");
        for (int i = 0; i < ladder.getWidth(); i++) {
            sb.append(String.format("%-6s", ladder.getLine(i).getName()));
        }
        sb.append("\n");
        System.out.println(sb);
    }

    private void printLadderContent() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ladder.getHeight(); i++) {
            sb.append(getLadderRow(i));
        }
        System.out.println(sb);
    }

    private String getLadderRow(int position) {
        StringBuilder sb = new StringBuilder();
        sb.append("\t").append(LADDER_LINE);
        for (int i = 0; i < ladder.getWidth() - 1; i++) {
            String status = ladder.getLine(i).isConnectedTo(ladder.getLine(i + 1), position) ? LADDER_EXIST : LADDER_EMPTY;
            sb.append(status).append(LADDER_LINE);
        }
        sb.append("\n");
        return sb.toString();
    }

    private void printLadderResults() {
        StringBuilder sb = new StringBuilder();
        sb.append("\t");
        for (int i = 0; i < ladder.getWidth(); i++) {
            sb.append(String.format("%-6s", ladder.getLine(i).getResult()));
        }
        sb.append("\n");
        System.out.println(sb);
    }

    public void printAllResults() {
        StringBuilder sb = new StringBuilder("실행결과\n");
        for (int i = 0; i < ladder.getWidth(); i++) {
            String name = ladder.getLine(i).getName();
            String result = ladder.getResult(i);
            sb.append(name).append(" : ").append(result).append("\n");
        }

        System.out.println(sb);
    }

    public void printResult(String playerName) {
        String result = ladder.getResult(playerName);

        StringBuilder sb = new StringBuilder();
        sb.append("실행결과\n")
                .append(result).append("\n");

        System.out.println(sb);
    }

    public void printGameEnd() {
        System.out.println("게임을 종료합니다.");
    }
}
