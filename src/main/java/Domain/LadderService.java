package Domain;

import java.util.List;

public class LadderService {
    private Ladder ladder;

    public void makeLadder(int height, int manCount) {
        ladder = new Ladder(height, manCount);
    }

    public Ladder getLadder() {
        return ladder;
    }

    public List<Integer> getPlayerDstIdx(List<Integer> playerIdxLst) {
        return ladder.getPlayerDstIdx(playerIdxLst);
    }


}
