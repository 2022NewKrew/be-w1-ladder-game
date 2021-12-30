package domain.ladder;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder {
    private static final int MIN_LENGTH = 1;
    private final List<LadderFrameLine> lines;

    public Ladder(int frameLength, int height) {
        LadderPrecondition.checkFrameLength(frameLength, MIN_LENGTH);
        LadderPrecondition.checkLadderHeight(height, MIN_LENGTH);
        this.lines = generateLines(frameLength - 1, height);
    }

    private List<LadderFrameLine> generateLines(int frameLength, int height) {
        return Stream.generate(()-> new LadderFrameLine(frameLength))
                .limit(height)
                .collect(Collectors.toUnmodifiableList());
    }


    public List<LadderFrameLine> getLines() {
        return lines;
    }
}
