package step01;

import java.util.Random;

public final class Ladder {
    private final int width;
    private final int height;
    private final char[][] result;
    private final Random random;

    private Ladder(int people, int ladderHeight) {
        this.width = people * 2 - 1;
        this.height = ladderHeight;
        this.result = new char[this.height][this.width];
        this.random = new Random();
        initLadder();
    }
    public static Ladder of(int n, int m){
        return new Ladder(n, m);
    }

    private void initLadder() {
        for(int i = 0; i < this.height; ++i) {
            for(int j = 0; j < this.width; ++j) {
                if (j % 2 == 0) {
                    this.result[i][j] = '|';
                } else {
                    this.result[i][j] =  random.nextBoolean() ? ' ' : '-';
                }
            }
        }

    }

    public void draw() {
        for(int i = 0; i < this.height; ++i) {
            System.out.println(String.valueOf(this.result[i]));
        }
    }
}
