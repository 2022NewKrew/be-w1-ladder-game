package domain.ladder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class LadderFrameLine {
    private static final Random randomGenerator = new Random();

    private final List<LadderFrame> ladderFrameList;

    public LadderFrameLine(int frameLineLength) {
        ladderFrameList = generateLadderLine(frameLineLength);
    }

    private List<LadderFrame> generateLadderLine(int frameLineLength) {
        List<LadderFrame> ladderFrameList = new ArrayList<>();
        LadderFrame previousLadderFrame = LadderFrame.SPACE;
        for (int i = 0; i < frameLineLength; i++) {
            previousLadderFrame = generateBridge(previousLadderFrame);
            ladderFrameList.add(previousLadderFrame);
        }
        return Collections.unmodifiableList(ladderFrameList);
    }

    private LadderFrame generateBridge(LadderFrame previousLadderFrame) {
        if (randomGenerator.nextBoolean() && previousLadderFrame.equals(LadderFrame.SPACE)) {
            return LadderFrame.BRIDGE;
        }
        return LadderFrame.SPACE;
    }

    public List<LadderFrame> getLadderFrameList() {
        return ladderFrameList;
    }
}
