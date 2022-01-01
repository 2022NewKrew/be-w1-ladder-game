package Domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class LadderCells implements Iterable<LadderCell> {

    List<LadderCell> ladderCells;

    public LadderCells(int cellCount) {
        ladderCells = new ArrayList<>();
        for (int i = 0; i < cellCount; i++)
            ladderCells.add(new LadderCell(decideHorizon(i)));
    }

    public boolean decideHorizon(int idx) {
        Random rand = new Random();
        if (idx != 0 && ladderCells.get(idx - 1).getIsHorizontal()) return false;
        return rand.nextBoolean();
    }

    public int size() {
        return ladderCells.size();
    }

    public LadderCell get(int idx) {
        return ladderCells.get(idx);
    }

    public void add(LadderCell ladderCell) {
        ladderCells.add(ladderCell);
    }

    public int calCol(int curIdx) {
        if (goLeft(curIdx)) return curIdx - 1;
        else if (goRight(curIdx)) return curIdx + 1;
        return curIdx;
    }

    private boolean goLeft(int curIdx) {
        int leftCol = curIdx - 1;
        return (leftCol >= 0 && ladderCells.get(leftCol).getIsHorizontal());
    }

    private boolean goRight(int rightCol) {
        return (rightCol < ladderCells.size() && ladderCells.get(rightCol).getIsHorizontal());
    }

    @Override
    public Iterator<LadderCell> iterator() {
        return ladderCells.iterator();
    }
}
