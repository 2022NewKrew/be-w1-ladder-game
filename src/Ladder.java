import java.util.Random;

public class Ladder {
    private final int numOfPeople;
    private final int height;
    private final char[][] ladder;

    Ladder(int numOfPeople, int height) {
        this.numOfPeople = numOfPeople;
        this.height = height;
        this.ladder = new char[height][getWidth()];

        construct();
    }

    private int getWidth() {
        return numOfPeople * 2 - 1;
    }

    private void construct() {
        Random random = new Random();

        for (int i = 0; i < height; ++i) {
            for (int j = 0; j < getWidth(); ++j) {
                if (j % 2 == 0) {
                    ladder[i][j] = '|';
                } else {
                    ladder[i][j] = (random.nextBoolean() ? '-' : ' ');
                }
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (char[] row : ladder) {
            for (char c : row) {
                sb.append(c);
            }
            sb.append('\n');
        }

        return sb.toString();
    }
}