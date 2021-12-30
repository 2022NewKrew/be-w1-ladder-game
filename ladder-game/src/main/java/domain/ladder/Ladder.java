package domain.ladder;

import preconditions.Precondition;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {
    private static final int MIN_LENGTH = 1;
    private final List<LadderFrameLine> lines;

    public Ladder(int frameLength, int height) {
        Precondition.checkFrameLength(frameLength, MIN_LENGTH);
        Precondition.checkLadderHeight(height, MIN_LENGTH);
        this.lines = generateLines(frameLength - 1, height);
    }

    private List<LadderFrameLine> generateLines(int frameLength, int height) {
        List<LadderFrameLine> generatedLines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            generatedLines.add(new LadderFrameLine(frameLength));
        }
        return Collections.unmodifiableList(generatedLines);
    }



    public List<LadderFrameLine> getLines() {
        return lines;
    }
}
