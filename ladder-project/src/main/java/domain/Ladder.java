package domain;

import util.RandomUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ladder {

    private final int line;
    private final int[][] ladder;

    public Ladder(int column, int height) {
        this.ladder = new int[height][column-1];
        this.line = generateRandomLine();
    }

    public void initLadder() {
        for(int i = 0; i < line; i++) {
            int r = RandomUtil.generate()%ladder.length;
            int c = RandomUtil.generate()%ladder[0].length;
            ladder[r][c] = 1;
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
            sb.append("|");
            if (block == 0) {
                sb.append(" ");
            }
            if (block == 1) {
                sb.append("-");
            }
        }
        sb.append("|");
        return sb;
    }

    private int generateRandomLine() {
        int totalSize = ladder.length*ladder[0].length;
        return RandomUtil.generate()%totalSize;
    }

    public int getLine() {
        return line;
    }
}
