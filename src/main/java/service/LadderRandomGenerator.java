package service;

import configuration.LadderHeight;
import configuration.PeopleCount;

import java.util.Random;

public class LadderRandomGenerator implements LadderGenerator {

    private static Random random = new Random();

    public boolean[][] generate(LadderHeight ladderHeight, PeopleCount peopleCount) {
        int height = ladderHeight.getValue();
        int width = peopleCount.getValue() - 1;

        if (height < 0 || width < 0) {
            return new boolean[0][0];
        }

        return generateLadderRows(height, width);
    }

    private boolean[][] generateLadderRows(int rowSize, int colSize) {
        boolean[][] ladderStatus = new boolean[rowSize][];

        for (int row = 0; row < ladderStatus.length; row++) {
            ladderStatus[row] = generateLadderRow(colSize);
        }

        return ladderStatus;
    }

    private boolean[] generateLadderRow(int colSize) {
        boolean[] ladderRow = new boolean[colSize];

        for (int col = 0; col < colSize; col++) {
            ladderRow[col] = random.nextBoolean();
        }

        return ladderRow;
    }
}