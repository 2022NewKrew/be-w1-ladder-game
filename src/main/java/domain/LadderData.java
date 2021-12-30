package domain;

import java.util.ArrayList;

public class LadderData {
    private final ArrayList<LadderRowData> ladderData;

    private LadderData(ArrayList<LadderRowData> ladderData) {
        this.ladderData = ladderData;
    }

    public static LadderData generateRandomly(int rows, int cols) {
        ArrayList<LadderRowData> randomLadderData = new ArrayList<>();
        for (int i = 0; i < rows; ++i) {
            randomLadderData.add(LadderRowData.generateRandomly(cols));
        }
        return new LadderData(randomLadderData);
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
