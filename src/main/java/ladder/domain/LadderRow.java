package ladder.domain;

import java.util.ArrayList;
import java.util.Random;

public class LadderRow {

    private final int ladderWidth;
    private final ArrayList<Boolean> row;

    public ArrayList<Boolean> getRow() {
        return row;
    }

    public LadderRow(int ladderWidth) {
        this.ladderWidth = ladderWidth;
        this.row = new ArrayList<>();
    }

    public void createLadderRow() {
        for (int i = 0; i < ladderWidth - 1; i++) {
            row.add(true);
            row.add(hasLadderAcrossLine());
        }
        row.add(true);
    }

    private boolean hasLadderAcrossLine() {
        return new Random().nextBoolean();
    }
}
