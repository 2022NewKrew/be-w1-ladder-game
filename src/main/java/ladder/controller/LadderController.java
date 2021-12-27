package ladder.controller;

import java.util.Random;

public class LadderController {

    private final char[][] ladder;
    private final Random random = new Random();

    public LadderController(int ladderCount, int personCount) {
        int rowCount = ladderCount;
        int columnCount = personCount * 2 - 1;

        ladder = new char[rowCount][columnCount];
        makeLadder(rowCount, columnCount);
    }

    private char makeLine(){
        if (random.nextBoolean()) {
            return '-';
        } else {
            return ' ';
        }
    }

    private void makeLadder(int rowCount, int columnCount) {
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < columnCount; j++) {
                if (j % 2 == 0) {
                    ladder[i][j] = '|';
                } else {
                    ladder[i][j] = makeLine();
                }
            }
        }
    }

    public char[][] getLadder() {
        return ladder;
    }
}
