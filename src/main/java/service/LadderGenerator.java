package service;

import java.util.Random;

public class LadderGenerator {

    private static Random random = new Random();

    public static boolean[][] generate(int height, int width) {

        if(height < 0 || width < 0) {
            return new boolean[0][0];
        }

        boolean[][] ladderStatus = new boolean[height][];
        for(int row = 0; row < ladderStatus.length; row++) {
            ladderStatus[row] = generateLadderRow(width);
        }

        return ladderStatus;
    }

    private static boolean[] generateLadderRow(int colSize) {

        boolean[] ladderRow = new boolean[colSize];

        for(int col = 0; col < colSize; col++) {
            ladderRow[col] = random.nextBoolean();
        }

        return ladderRow;
    }

}
