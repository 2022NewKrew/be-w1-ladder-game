package main.java.ladder.view;

import main.java.ladder.domain.Ladder;

import java.util.List;

public class LadderView {
    private static final int FORMAT_LENGTH = 6;

    private final List<String> players;
    private final Ladder ladder;

    public LadderView(List<String> players, int height) {
        this.players = players;
        ladder = new Ladder(players.size() * 2 - 1, height);
    }

    public String printLadder() {
        StringBuilder sb = new StringBuilder();
        players.forEach(player -> sb.append(padding(player)));
        sb.append('\n').append(ladder.toString());
        return sb.toString();
    }

    private String padding(String name) {
        int margin = FORMAT_LENGTH - name.length();
        int rightPadding = margin / 2;
        int leftPadding = margin - rightPadding;
        return " ".repeat(leftPadding) + name + " ".repeat(rightPadding);
    }
}
