package Domain;

import java.util.List;

public class LadderService {
    private Ladder ladder;

    public void makeLadder(int height, int manCount) {
        ladder = Ladder.getInstance(height, manCount);
        ladder.makeDstLst();
    }

    public Ladder getLadder() {
        return ladder;
    }

    public List<Integer> getPlayerDstIdx(List<Integer> playerIdxLst) {
        return ladder.getPlayerDstIdx(playerIdxLst);
    }


}
