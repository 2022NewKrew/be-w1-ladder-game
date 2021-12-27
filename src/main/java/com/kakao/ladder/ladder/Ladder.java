package com.kakao.ladder.ladder;

import java.util.ArrayList;

public class Ladder {

    private final int width;
    private final int height;
    private final ArrayList<Line> lines;

    private Ladder(int n, int m) {
        this.width = n;
        this.height = m;
        lines = new ArrayList<>();
    }

    public static Ladder create(int n, int m) {
        Ladder ladder = new Ladder(n, m);
        ladder.drawLines();
        return ladder;
    }

    private void drawLines() {
        for (int i = 0; i < height; i++) {
            Line line = new Line();
            line.draw(width);
            lines.add(line);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Line line : lines) {
            sb.append(line).append("\n");
        }
        return sb.toString();
    }
}
