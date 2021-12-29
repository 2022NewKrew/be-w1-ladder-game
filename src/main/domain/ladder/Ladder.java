package main.domain.ladder;

import main.domain.line.Line;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    public static final int MAX_NAME_LENGTH = 5;

    private final int height;
    private final List<Line> lines = new ArrayList<>();

    public Ladder(String[] players, int height) {
        this.height = height;
        for (int i = 0; i < players.length; i++) {
            lines.add(new Line(cutOffTheName(players[i]), height));
        }
    }

    private String cutOffTheName(String s) {
        return s.substring(0, Math.min(s.length(), MAX_NAME_LENGTH));
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return lines.size();
    }

    public Line getLine(int position) {
        return this.lines.get(position);
    }
}
