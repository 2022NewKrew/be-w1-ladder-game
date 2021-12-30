package ladderGame.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private static final String ERROR_INVALID_LADDER_HEIGHT = "사다리의 높이는 0보다 큰 숫자를 입력해야합니다.";

    private final int ladderHeight;
    private final int ladderWidth;
    private final List<LadderLine> ladderLines;

    public Ladder(int ladderHeight, int ladderWidth, List<LadderLine> ladderLines) {
        this.ladderHeight = ladderHeight;
        this.ladderWidth = ladderWidth;
        this.ladderLines = new ArrayList<>(ladderLines);
    }

    public static Ladder makeLadder(int ladderHeight, int ladderWidth) {
        validateLadder(ladderHeight);

        List<LadderLine> ladderLines = new ArrayList<>();

        for (int i = 0; i < ladderHeight; ++i) {
            ladderLines.add(LadderLine.makeLadderLine(ladderWidth));
        }

        return new Ladder(ladderHeight, ladderWidth, ladderLines);
    }

    private static void validateLadder(int ladderHeight) {
        if (ladderHeight <= 0) {
            throw new IllegalArgumentException(ERROR_INVALID_LADDER_HEIGHT);
        }
    }

    public List<LadderLine> getLadderLines() {
        return ladderLines;
    }
}
