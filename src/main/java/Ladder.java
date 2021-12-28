import java.util.Random;

public class Ladder {
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
                if (j % 2 == 0) {
                    ladder[i][j] = '|';
                } else {
                    ladder[i][j] = ' ';
                }
            }
        }
    }

    public void makeRandomLadder() {
        Random random = new Random();

        for (int i = 0; i < height; i++) {
            for (int j = 1; j < width; j += 2) {
                if (j - 2 >= 0 && ladder[i][j - 2] == '-') {
                    continue;
                }

                if (random.nextBoolean()) {
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
}
