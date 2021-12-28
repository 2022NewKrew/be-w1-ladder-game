package service;

import java.util.Random;

public class LadderGenerator {

    private static Random random = new Random();

    public static boolean[][] generate(int height, int width) {
        if(height < 0 || width < 0) {
            return new boolean[0][0];
        }

        return generateLadderRows(height, width);
    }

    private static boolean[][] generateLadderRows(int rowSize, int colSize) {
        boolean[][] ladderStatus = new boolean[rowSize][];

        for(int row = 0; row < ladderStatus.length; row++) {
            ladderStatus[row] = generateLadderRow(colSize);
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
