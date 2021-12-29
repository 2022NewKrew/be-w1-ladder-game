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
        for (int i = 0; i < frameLineLength; i++) {
            ladderFrameList.add(generateBridge());
        }
        return Collections.unmodifiableList(ladderFrameList);
    }

    private LadderFrame generateBridge() {
        if (randomGenerator.nextBoolean()) {
            return LadderFrame.BRIDGE;
        }
        return LadderFrame.SPACE;
    }

    public List<LadderFrame> getLadderFrameList() {
        return ladderFrameList;
    }
}
