package ladderGame.model;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final int ladderHeight;
    private final int ladderWidth;
    private final List<LadderLine> ladderLines;

    public Ladder(int ladderHeight, int ladderWidth, List<LadderLine> ladderLines) {
        this.ladderHeight = ladderHeight;
        this.ladderWidth = ladderWidth;
        this.ladderLines = new ArrayList<>(ladderLines);
    }

    public static Ladder makeLadder(int ladderHeight, int ladderWidth) {
        List<LadderLine> ladderLines = new ArrayList<>();

        for (int i = 0; i < ladderHeight; ++i) {
            ladderLines.add(LadderLine.makeLadderLine(ladderWidth));
        }

        return new Ladder(ladderHeight, ladderWidth, ladderLines);
    }

    public List<LadderLine> getLadderLines() {
        return ladderLines;
    }
}
