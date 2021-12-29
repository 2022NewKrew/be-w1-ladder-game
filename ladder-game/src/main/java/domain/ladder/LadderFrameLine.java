package domain.ladder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class LadderFrameLine {
    private static final Random randomGenerator = new Random();

    private final List<LadderFrame> frames;

    public LadderFrameLine(int numberOfFrame) {
        frames = generateFrames(numberOfFrame);
    }

    private List<LadderFrame> generateFrames(int numberOfFrame) {
        List<LadderFrame> frames = new ArrayList<>();
        LadderFrame previousFrame = LadderFrame.SPACE;
        for (int i = 0; i < numberOfFrame; i++) {
            previousFrame = generateBridge(previousFrame);
            frames.add(previousFrame);
        }
        return Collections.unmodifiableList(frames);
    }

    private LadderFrame generateBridge(LadderFrame previousFrame) {
        if (randomGenerator.nextBoolean() && previousFrame.equals(LadderFrame.SPACE)) {
            return LadderFrame.BRIDGE;
        }
        return LadderFrame.SPACE;
    }

    public List<LadderFrame> getFrames() {
        return frames;
    }
}
