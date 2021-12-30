package domain.ladder;

import utility.RandomGenerator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LadderFrameLine {
    private final List<LadderFrame> frames;

    public LadderFrameLine(int numberOfFrame) {
        frames = generateFrames(numberOfFrame);
    }

    private List<LadderFrame> generateFrames(int numberOfFrame) {
        return Stream.iterate(LadderFrame.SPACE, this::generateBridge).skip(1).limit(numberOfFrame).collect(Collectors.toUnmodifiableList());
    }

    private LadderFrame generateBridge(LadderFrame previousFrame) {
        if (RandomGenerator.getNextBoolean() && previousFrame.equals(LadderFrame.SPACE)) {
            return LadderFrame.BRIDGE;
        }
        return LadderFrame.SPACE;
    }

    public List<LadderFrame> getFrames() {
        return frames;
    }
}
