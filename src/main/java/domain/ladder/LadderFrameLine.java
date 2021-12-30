package domain.ladder;

<<<<<<< HEAD
import utility.RandomGenerator;

import java.util.List;
=======
import java.util.List;
import java.util.Random;
>>>>>>> 05c0cd8 (리뷰받은 내용 중 gradle관련 수정)
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LadderFrameLine {
<<<<<<< HEAD
=======
    private static final Random randomGenerator = new Random();

>>>>>>> 05c0cd8 (리뷰받은 내용 중 gradle관련 수정)
    private final List<LadderFrame> frames;

    public LadderFrameLine(int numberOfFrame) {
        frames = generateFrames(numberOfFrame);
    }

    private List<LadderFrame> generateFrames(int numberOfFrame) {
<<<<<<< HEAD
        return Stream.iterate(LadderFrame.SPACE, this::generateBridge).skip(1).limit(numberOfFrame).collect(Collectors.toUnmodifiableList());
    }

    private LadderFrame generateBridge(LadderFrame previousFrame) {
        if (RandomGenerator.getNextBoolean() && previousFrame.equals(LadderFrame.SPACE)) {
=======
        return Stream.iterate(LadderFrame.SPACE, this::generateBridge)
                .skip(1)
                .limit(numberOfFrame)
                .collect(Collectors.toUnmodifiableList());
    }

    private LadderFrame generateBridge(LadderFrame previousFrame) {
        if (randomGenerator.nextBoolean() && previousFrame.equals(LadderFrame.SPACE)) {
>>>>>>> 05c0cd8 (리뷰받은 내용 중 gradle관련 수정)
            return LadderFrame.BRIDGE;
        }
        return LadderFrame.SPACE;
    }

    public List<LadderFrame> getFrames() {
        return frames;
    }
}
