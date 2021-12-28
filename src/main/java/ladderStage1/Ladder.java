package ladderStage1;

import java.util.Random;

public class Ladder {
    private final int manCnt;
    private final int maxHeight;
    private final boolean[][] ladderArr;

    Ladder(int manCnt, int maxHeight) {
        this.manCnt = manCnt;
        this.maxHeight = maxHeight;
        ladderArr = new boolean[maxHeight][manCnt - 1];
    }

    public void make() {
        Random random = new Random();
        for(int row = 0; row < maxHeight; row++) {
            for(int col = 0; col < manCnt - 1; col++) {
                ladderArr[row][col] = random.nextInt(2) == 1;
            }
        }
    }

    public void print() {
        for(int row = 0; row < maxHeight; row++) {
            for(int col = 0; col < manCnt - 1; col++) {
                System.out.print("|");
                System.out.print(ladderArr[row][col] ? "-" : " ");
            }
            System.out.println("|");
        }
    }
}