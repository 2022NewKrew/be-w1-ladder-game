package laddergame.domain;

public class Ladder {
    private int width;
    private int height;
    private Lines lines;

    Ladder(int width, int height, Lines lines) {
        this.width = width;
        this.height = height;
        this.lines = lines;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Line getLineByIndex(int index) {
        return lines.getLineByIndex(index);
    }
}