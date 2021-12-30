package domain;

import java.util.ArrayList;
import java.util.Random;

public class LadderData {
    private final int rows;
    private final int cols;
    private final ArrayList<LadderRowData> ladderData = new ArrayList<>();

    public LadderData(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        generateRandomData();
    }

    private void generateRandomData() {
        for (int i = 0; i < rows; ++i) {
            ladderData.add(LadderRowData.generateByRandom(cols));
        }
    }

    public StringBuilder toStringBuilder(int ladderLength) {
        StringBuilder ladderDataStringBuilder = new StringBuilder();
        int leftPadding = ladderLength / 2;
        for (LadderRowData ladderRowData : ladderData) {
            ladderDataStringBuilder.append(" ".repeat(leftPadding));
            ladderDataStringBuilder.append(ladderRowData.toStringBuilder(ladderLength));
            ladderDataStringBuilder.append("\n");
        }
        return ladderDataStringBuilder;
    }
}
