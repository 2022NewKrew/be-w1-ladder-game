package Ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LadderRow {
    private final List<Boolean> horizonBranch = new ArrayList<>();
    private static final Random random = new Random();

    public LadderRow(int numParticipants) {
        for (int i = 0; i < numParticipants-1; i++) {
            horizonBranch.add(getRandomHorizonBranch(i));
        }
    }

    public String toString() {
        StringBuffer ladderRow = new StringBuffer();

        ladderRow.append("  " + LadderShape.VERTICAL_BRANCH);
        for (int col = 0; col < horizonBranch.size(); col++) {
            ladderRow.append(selectCharacter(horizonBranch.get(col)));
            ladderRow.append(LadderShape.VERTICAL_BRANCH);
        }
        ladderRow.append("\n");

        return ladderRow.toString();
    }

    private Boolean getRandomHorizonBranch(int idx) {
        if (idx > 0 && horizonBranch.get(idx - 1)) return false;
        return random.nextBoolean();
    }

    private String selectCharacter(boolean isExistHorizon) {
        if (isExistHorizon) return LadderShape.HORIZON_BRANCH;
        return LadderShape.NO_HORIZON_BRANCH;
    }

}
