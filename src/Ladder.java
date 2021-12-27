import java.util.Random;

public class Ladder {
    private int height;
    private int width;
    private char[][] ladder;

    public Ladder(int height, int width, char[][] ladder) {
        this.height = height;
        this.width = width;
        this.ladder = ladder;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public char[][] getLadder() {
        return ladder;
    }
}
