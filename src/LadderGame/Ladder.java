package LadderGame;

public class Ladder {
    private int height;
    private int width;
    private char[][] ladder;

    public Ladder(int height, int width) {
        this.height = height;
        this.width = width;
        this.ladder = new char[height][width];
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public char[][] getLadder() {
        return ladder;
    }

    public void setLadder(char[][] ladder) {
        this.ladder = ladder;
    }
}
