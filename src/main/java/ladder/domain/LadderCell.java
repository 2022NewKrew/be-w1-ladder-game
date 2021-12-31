package ladder.domain;

import java.util.Random;

public class LadderCell {

    private final LineType lineType;

    public LadderCell(LineType previousLineType) {
        this.lineType = createLineType(previousLineType);
    }

    private LineType createLineType(LineType previousLineType) {
        if (previousLineType == LineType.HORIZONTAL_LINE) {
            return LineType.EMPTY_LINE;
        }
        return selectLineType();
    }

    private LineType selectLineType() {
        if (new Random().nextBoolean()) {
            return LineType.HORIZONTAL_LINE;
        }
        return LineType.EMPTY_LINE;
    }

    public LineType getLine() {
        return lineType;
    }
}
