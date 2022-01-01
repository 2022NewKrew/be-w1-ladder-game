package laddergame.domain;

public class Ladder {
    private int width;
    private int height;
    private Lines lines = new Lines();

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
        return lines.getLineByIndex(index);
    }

    public void makeLadder() {
        lines.makeLines(height, width);
    }
}