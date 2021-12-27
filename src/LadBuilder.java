import java.util.Random;

public class LadBuilder {

    public LadBuilder() {
    }

    public Ladder createLadder(int height, int people) {
        int width = people * 2 - 1;
        char[][] ladder_temp = new char[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (j % 2 == 0) {
                    ladder_temp[i][j] = '|';
                } else {
                    ladder_temp[i][j] = getRandomLine();
                }
            }
        }
        return new Ladder(height, width, ladder_temp);
    }

    private char getRandomLine() {
        Random random = new Random();
        return random.nextBoolean() ? '-' : ' ';
    }
}
