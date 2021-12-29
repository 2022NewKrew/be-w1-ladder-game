import java.util.Random;

public class Ladder {

    private static final char VERTICAL_LINE = '|';
    private static final char HORIZONTAL_LINE = '-';
    private static final char EMPTY_LINE = ' ';
    private static final Random random = new Random();
    private final int width;
    private final int height;
    private char[][] ladderMap;


    public Ladder(int numOfPeople, int height) {
        this.width = 2*numOfPeople -1;
        this.height = height;
        createLadder();
    }

    private void createLadder() {
        ladderMap = new char[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (j % 2 == 0) {
                    ladderMap[i][j] = VERTICAL_LINE;
                } else {
                    ladderMap[i][j] = getRandomLine();
                }
            }
        }
    }

    private char getRandomLine() {
        return random.nextBoolean() ? HORIZONTAL_LINE : EMPTY_LINE;
    }

    public char[][] getLadderMap() {
        return ladderMap;
    }
}
