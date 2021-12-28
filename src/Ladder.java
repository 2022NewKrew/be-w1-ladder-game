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

    public char[][] getLadder() {
        return ladder;
    }
}
