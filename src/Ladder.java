import java.util.Random;

public class Ladder {
    private int height;
    private int width;
    private char[][] ladder;

    public Ladder(int height, int people) {
        this.height = height; // 사다리 높이
        this.width = 2 * people - 1; // 사다리 너비는 중간에 가로라인 생기니까 2*사람수-1 개
        makeLadder();
    }

    private void makeLadder() {
        ladder = new char[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (j % 2 == 0) {
                    ladder[i][j] = '|';
                } else {
                    ladder[i][j] = getRandomLine();
                }
            }
        }
    }

    private char getRandomLine() {
        Random random = new Random();
        return random.nextBoolean() ? '-' : ' ';
    }

    public void printLadder() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(ladder[i][j]);
            }
            System.out.print('\n');
        }
    }
}
