package Ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LadderRow {
    private List<Boolean> horizonBranch = new ArrayList<>();
    private static Random random = new Random();

    public LadderRow(int numParticipants) {
        for (int i = 0; i < numParticipants-1; i++) {
            if (i > 0 && horizonBranch.get(i-1)) horizonBranch.add(false);
            else horizonBranch.add(random.nextBoolean());
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

    private String selectCharacter(boolean isExistHorizon) {
        if (isExistHorizon) return LadderShape.HORIZON_BRANCH;
        return LadderShape.NO_HORIZON_BRANCH;
    }

}
