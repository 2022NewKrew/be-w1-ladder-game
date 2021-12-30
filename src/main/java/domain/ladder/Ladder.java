package domain.ladder;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder {
<<<<<<< HEAD
    private static final int FRAME_MIN_LENGTH = 1;
    private static final int HEIGHT_MIN_LENGTH = 1;
    private final List<LadderFrameLine> lines;

    public Ladder(int frameLength, int height) {
        LadderPrecondition.checkFrameLength(frameLength, FRAME_MIN_LENGTH);
        LadderPrecondition.checkLadderHeight(height, HEIGHT_MIN_LENGTH);
        this.lines = generateLines(frameLength, height);
=======
    private static final int MIN_LENGTH = 1;
    private final List<LadderFrameLine> lines;

    public Ladder(int frameLength, int height) {
        LadderPrecondition.checkFrameLength(frameLength, MIN_LENGTH);
        LadderPrecondition.checkLadderHeight(height, MIN_LENGTH);
        this.lines = generateLines(frameLength - 1, height);
>>>>>>> 05c0cd8 (리뷰받은 내용 중 gradle관련 수정)
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
