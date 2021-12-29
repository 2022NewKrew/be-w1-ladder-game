package domain;

import util.RandomUtil;

public class Ladder {

    private final int line;
    private final int[][] ladder;

    public Ladder(int column, int height) {
        this.ladder = new int[height][column - 1];
        this.line = generateRandomLine();
        assert this.line > -1;
        initLadder();
    }

    private void initLadder() {
        for (int i = 0; i < line; i++) {
            int rowPosition = RandomUtil.generateSpecificRange(ladder.length);
            int columnPosition = RandomUtil.generateSpecificRange(ladder[0].length);
            ladder[rowPosition][columnPosition] = 1;
        }
    }

    public int[][] getLadder() {
        return ladder;
    }

    private int generateRandomLine() {
        return RandomUtil.generateSpecificRange(getLadderSize());
    }

    private int getLadderSize() {
        return ladder.length * ladder[0].length;
    }
}
