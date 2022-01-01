package laddergame.domain;

import java.util.ArrayList;

public class Ladder {
    private int width;
    private int height;
    private ArrayList<Line> lines = new ArrayList<Line>();

    public Ladder(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Line getLineByIndex(int index) {
        return lines.get(index);
    }

    public void makeLadder() {
        for (int i = 0; i < height; i++)
            lines.add(new Line(width));
    }
}