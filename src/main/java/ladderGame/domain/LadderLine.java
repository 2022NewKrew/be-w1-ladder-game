package ladderGame.domain;

import ladderGame.util.RandomUtil;

import java.util.ArrayList;
import java.util.List;

public class LadderLine {
    private final List<LadderLineBranch> ladderLineBranches;

    public LadderLine(List<LadderLineBranch> ladderLineBranches) {
        this.ladderLineBranches = new ArrayList<>(ladderLineBranches);
    }

    public static LadderLine makeLadderLine(int ladderWidth) {
        List<LadderLineBranch> ladderLineBranches = new ArrayList<>();

        ladderLineBranches.add(new LadderLineBranch(RandomUtil.getRandomBoolean()));
        for (int i = 1; i < ladderWidth; ++i) {
            ladderLineBranches.add(new LadderLineBranch(makeBranch(i, ladderLineBranches)));
        }

        return new LadderLine(ladderLineBranches);
    }

    private static boolean makeBranch(int index, List<LadderLineBranch> ladderLineBranches) {
        if (ladderLineBranches.get(index - 1).isConnect()) {
            return false;
        }

        return RandomUtil.getRandomBoolean();
    }

    public List<LadderLineBranch> getladderLineBranches() {
        return ladderLineBranches;
    }
}
