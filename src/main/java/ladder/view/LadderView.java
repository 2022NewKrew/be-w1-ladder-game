package main.java.ladder.view;

import main.java.ladder.domain.Ladder;

import java.util.List;

public class LadderView {
    private static final String NEW_LINE = "\n";
    private static final int FORMAT_LENGTH = 6;

    private final List<String> players;
    private final List<String> results;
    private final Ladder ladder;

    public LadderView(List<String> players, List<String> results, int height) {
        this.players = players;
        this.results = results;
        ladder = new Ladder(players.size() * 2 - 1, height);
    }

    public String printLadderResult() {
        StringBuilder sb = new StringBuilder();
        sb.append("사다리 결과").append(NEW_LINE).append(NEW_LINE);
        players.forEach(player -> sb.append(padding(player)));
        sb.append(NEW_LINE).append(ladder.printLadder());
        results.forEach(result -> sb.append(padding(result)));
        return sb.toString();
    }

    private String padding(String str) {
        int margin = FORMAT_LENGTH - str.length();
        int rightPadding = margin / 2;
        int leftPadding = margin - rightPadding;
        return " ".repeat(leftPadding) + str + " ".repeat(rightPadding);
    }

    public Ladder getLadder() {
        return ladder;
    }
}