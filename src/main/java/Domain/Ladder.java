package Domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private int height;
    private int manCount;
    private LadderRows ladderRows;
    private LadderDestinations ladderDestinations;

    public Ladder(int height, int manCount) {

        if (height < 1) {
            throw new IllegalArgumentException("사다리의 높이는 1 이상 이어야 합니다!");
        }
        if (manCount < 2) {
            throw new IllegalArgumentException("플레이어는 2 명 이상 이어야 합니다!");
        }

        this.height = height;
        this.manCount = manCount;
        this.ladderRows = new LadderRows(height, manCount);
        this.ladderDestinations = new LadderDestinations(this.ladderRows, manCount);
    }


    public List<Integer> getPlayerDstIdx(List<Integer> playerIdxLst) {
        List<Integer> dstIdxLst = new ArrayList<>();
        for (int playerIdx : playerIdxLst)
            dstIdxLst.add(ladderDestinations.get(playerIdx).getDst());
        return dstIdxLst;
    }

    public LadderRows getLadderRows() {
        return ladderRows;
    }
}
