package Domain;

import java.util.Iterator;
import java.util.List;

public class LadderDestinations implements Iterable<LadderDestination> {

    List<LadderDestination> ladderDestinations;

    public LadderDestinations(LadderRows ladderRows, int manCount) {
        ladderDestinations = ladderRows.makeLadderDestinations(manCount);
    }

    @Override
    public Iterator<LadderDestination> iterator() {
        return ladderDestinations.iterator();
    }

    public LadderDestination get(int idx) {
        return ladderDestinations.get(idx);
    }
}
