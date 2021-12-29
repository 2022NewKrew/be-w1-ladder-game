package Ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LadderRow {
<<<<<<< HEAD
    private final List<Boolean> horizonBranch = new ArrayList<>();
    private static final Random random = new Random();

    public LadderRow(int numParticipants) {
        for (int i = 0; i < numParticipants-1; i++) {
            horizonBranch.add(getRandomHorizonBranch(i));
        }
=======
    private List<Boolean> horizonBranch = new ArrayList<>();
    private static Random random = new Random();

    public LadderRow(int numParticipants) {
        for (int i = 0; i < numParticipants-1; i++) {
            if (i > 0 && horizonBranch.get(i-1)) horizonBranch.add(false);
            else horizonBranch.add(random.nextBoolean());
        }

>>>>>>> 6ea4f61 ([feat] step3 구현)
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

<<<<<<< HEAD
    private Boolean getRandomHorizonBranch(int idx) {
        if (idx > 0 && horizonBranch.get(idx - 1)) return false;
        return random.nextBoolean();
    }

=======
>>>>>>> 6ea4f61 ([feat] step3 구현)
    private String selectCharacter(boolean isExistHorizon) {
        if (isExistHorizon) return LadderShape.HORIZON_BRANCH;
        return LadderShape.NO_HORIZON_BRANCH;
    }

}
