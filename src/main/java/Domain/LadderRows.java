package Domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LadderRows implements Iterable<LadderRow> {
    List<LadderRow> ladderRows;

    public LadderRows(int height, int manCount) {
        ladderRows = new ArrayList<>();
        for (int i = 0; i < height; i++)
            ladderRows.add(new LadderRow(manCount));
    }

    @Override
    public Iterator<LadderRow> iterator() {
        return ladderRows.iterator();
    }

    public int size() {
        return ladderRows.size();
    }

    public LadderRow get(int idx) {
        return ladderRows.get(idx);
    }

    int calDst(int start) {
        int dst = start;
        for (int i = 0; i < ladderRows.size(); i++) {
            dst = ladderRows.get(i).calCol(dst);
        }
        return dst;
    }

    List<LadderDestination> makeLadderDestinations() {
        List<LadderDestination> ladderDestinations = new ArrayList<>();
        for (int i = 0; i < ladderRows.size(); i++)
            ladderDestinations.add(new LadderDestination(i, calDst(i)));
        return ladderDestinations;
    }

}
