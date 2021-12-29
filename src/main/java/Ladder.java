import java.util.Random;

public class Ladder {
    private static final Random RANDOM = new Random();
    private static final char VERTICAL_BAR = '|';
    private static final char CROSS_BAR = '-';
    private static final char BLANK = ' ';

    private int height;
    private int width;
    private char[][] ladder;

    public Ladder(int height, int numOfPeople) {
        this.height = height;
        this.width = numOfPeople * 2 - 1;
        this.ladder = new char[this.height][this.width];
        initializeLadder();
    }

    public void initializeLadder() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                ladder[i][j] = (j % 2 == 0) ? VERTICAL_BAR : BLANK;
            }
        }
    }

    public void makeRandomLadder() {
        for (int i = 0; i < height; i++) {
            for (int j = 1; j < width; j += 2) {
                if (isAvailableLocation(i, j)) {
                    ladder[i][j] = '-';
                }
            }
        }
    }

    public void printLadder() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(ladder[i][j]);
            }
            System.out.print('\n');
        }
    }

    private boolean isAvailableLocation(int y, int x) {
        if (x - 2 >= 0 && ladder[y][x - 2] == CROSS_BAR) {
            return false;
        }

        if (!RANDOM.nextBoolean()) {
            return false;
        }

        return true;
    }
}
