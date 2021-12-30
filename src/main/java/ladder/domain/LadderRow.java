package ladder.domain;

import ladder.view.ShapeCharacter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LadderRow {

    public List<Boolean> horizonBranch = new ArrayList<>();
    private static final Random random = new Random();

    public LadderRow(int numParticipants) {
        for (int i = 0; i < numParticipants - 1; i++) {
            horizonBranch.add(getRandomHorizonBranch(i));
        }
    }

    public String toString() {
        StringBuffer ladderRow = new StringBuffer();

        ladderRow.append("  " + ShapeCharacter.VERTICAL_BRANCH);
        for (int col = 0; col < horizonBranch.size(); col++) {
            ladderRow.append(selectCharacter(horizonBranch.get(col)));
            ladderRow.append(ShapeCharacter.VERTICAL_BRANCH);
        }
        ladderRow.append("\n");

        return ladderRow.toString();
    }

    private Boolean getRandomHorizonBranch(int idx) {
        if (idx > 0 && horizonBranch.get(idx - 1)) return false;
        return random.nextBoolean();
    }

    private String selectCharacter(boolean isExistHorizon) {
        if (isExistHorizon) return ShapeCharacter.HORIZON_BRANCH;
        return ShapeCharacter.NO_HORIZON_BRANCH;
    }

}
