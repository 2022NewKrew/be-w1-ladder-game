import java.util.Random;

public class Ladder {

    private static final char VERTICAL_LINE = '|';
    private static final char HORIZONTAL_LINE = '-';
    private static final char EMPTY_LINE = ' ';
    private static Random random = new Random();
    private int height;
    private int width;
    private char[][] ladderMap;


    public Ladder(int height, int numOfPeople) {
        this.height = height;
        this.width = 2*numOfPeople -1;
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

    public char[][] getLadder() {
        return ladderMap;
    }
}
