package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 사다리 클래스. {@link LadderRow}의 리스트로 구성되어 있다
 */
public class Ladder {
    private final List<LadderRow> rows = new ArrayList<>();

    public Ladder(int numOfPeople, int height) {
        for (int i = 0; i < height; ++i) {
            rows.add(new LadderRow(numOfPeople));
        }
    }

    public List<LadderRow> getRows() {
        return Collections.unmodifiableList(rows);
    }

    public int getRunResult(int startIndex) {
        int yPos = 0;
        int xPos = startIndex;
        final int width = rows.get(0).getSteps().size();
        LadderRow row;

        while (yPos < rows.size()) {
            row = rows.get(yPos);
            xPos += getXPosDelta(row, xPos, width);
            ++yPos;
        }

        return xPos;
    }

    private int getXPosDelta(LadderRow row, int xPos, final int width) {
        if (xPos < width && row.getSteps().get(xPos) == Step.FILLED) {
            return 1;
        }
        if (xPos > 0 && row.getSteps().get(xPos-1) == Step.FILLED) {
            return -1;
        }
        return 0;
    }
}
