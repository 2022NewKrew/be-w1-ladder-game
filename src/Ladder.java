import java.util.Random;

public class Ladder {
    private int height;
    private int width;
    private char[][] ladder;

    public Ladder(int height, int width) {
        this.height = height;
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public void setLadder(char[][] ladder) {
        this.ladder = ladder;
    }
    public char[][] getLadder() {
        return ladder;
    }
}
