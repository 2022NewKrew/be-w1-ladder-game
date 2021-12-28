package domain.ladder;

import util.RandomUtil;

public class Ladder {

    private final int line;
    private final int[][] ladder;
    private final LadderShape ladderShape;

    public Ladder(int column, int height) {
        this.ladder = new int[height][column - 1];
        this.line = generateRandomLine();
        assert this.line > -1;
        initLadder();
        this.ladderShape = LadderShape.create(ladder);
    }

    private void initLadder() {
        for (int i = 0; i < line; i++) {
            int rowPosition = RandomUtil.generateSpecificRange(ladder.length);
            int columnPosition = RandomUtil.generateSpecificRange(ladder[0].length);
            ladder[rowPosition][columnPosition] = 1;
        }
    }

    public String getLadderShape() {
        return ladderShape.getShape();
    }

    private int generateRandomLine() {
        return RandomUtil.generateSpecificRange(getLadderSize());
    }

    private int getLadderSize() {
        return ladder.length * ladder[0].length;
    }
}
