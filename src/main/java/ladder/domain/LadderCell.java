package ladder.domain;

import java.util.Random;

public class LadderCell {

    private final boolean line;

    public LadderCell(boolean previousLadderCell) {
        this.line = createLadderCell(previousLadderCell);
    }

    private boolean createLadderCell(boolean previousLadderCell) {
        if (previousLadderCell) {
            return false;
        }

        return new Random().nextBoolean();
    }

    public boolean getLine() {
        return line;
    }
}
