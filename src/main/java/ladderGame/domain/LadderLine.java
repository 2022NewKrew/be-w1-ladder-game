package ladderGame.domain;

import ladderGame.util.RandomUtil;

import java.util.ArrayList;
import java.util.List;

public class LadderLine {
    private final List<Boolean> oneLadderLines;

    public LadderLine(List<Boolean> oneLadderLines) {
        this.oneLadderLines = new ArrayList<>(oneLadderLines);
    }

    public static LadderLine makeLadderLine(int ladderWidth) {
        List<Boolean> oneLadderLines = new ArrayList<>();

        oneLadderLines.add(RandomUtil.getRandomBoolean());
        for (int i = 1; i < ladderWidth; ++i) {
            oneLadderLines.add(makeBranch(i, oneLadderLines));
        }

        return new LadderLine(oneLadderLines);
    }

    private static boolean makeBranch(int index, List<Boolean> oneLadderLines) {
        if (oneLadderLines.get(index - 1)) {
            return false;
        }

        return RandomUtil.getRandomBoolean();
    }

    public List<Boolean> getOneLadderLines() {
        return oneLadderLines;
    }
}
