package domain.ladder;

import util.RandomUtil;

public class Ladder {

    private final int line;
    private final int[][] ladder;

    public Ladder(int column, int height) {
        this.ladder = new int[height][column - 1];
        this.line = generateRandomLine();
        assert this.line > -1;
    }

    public void initLadder() {
        for (int i = 0; i < line; i++) {
            int rowPosition = RandomUtil.generateSpecificRange(ladder.length);
            int columnPosition = RandomUtil.generateSpecificRange(ladder[0].length);
            ladder[rowPosition][columnPosition] = 1;
        }
    }

    public String generateLadderShape() {
        StringBuilder sb = new StringBuilder();
        for (int[] ladderLine : ladder) {
            sb.append(generateLadderLine(ladderLine));
            sb.append("\n");
        }
        return sb.toString();
    }

    private StringBuilder generateLadderLine(int[] line) {
        StringBuilder sb = new StringBuilder();
        for (int block : line) {
            sb.append(LadderComponent.LADDER_ROW_LINE.getValue());
            if (block == 0) {
                sb.append(LadderComponent.LADDER_EMPTY_COLUMN.getValue());
            }
            if (block == 1) {
                sb.append(LadderComponent.LADDER_COLUMN_LINE.getValue());
            }
        }
        sb.append(LadderComponent.LADDER_ROW_LINE.getValue());
        return sb;
    }

    private int generateRandomLine() {
        return RandomUtil.generateSpecificRange(getLadderSize());
    }

    private int getLadderSize() {
        return ladder.length * ladder[0].length;
    }
}
