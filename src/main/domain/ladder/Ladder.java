package main.domain.ladder;

import main.domain.line.Line;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final int height;
    private final List<Line> lines = new ArrayList<>();

    public Ladder(String[] players, int height) {
        this.height = height;
        for (int i = 0; i < players.length; i++) {
            lines.add(new Line(players[i], height));
        }
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
