package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Line {

    private final ArrayList<Boolean> bridges;
    private final Random random = new Random();

    public Line(int columnCount) {
        this.bridges = new ArrayList<>();
        makeLine(columnCount);
    }

    private void makeLine(int columnCount) {
        for (int j = 0; j < columnCount; j++) {
            bridges.add(makeBridge(j));
        }
    }

    private boolean makeBridge(int index) {
        return random.nextBoolean() && !hasLeftBridge(index);
    }

    private boolean hasLeftBridge(int index) {
        if (index == 0) {
            return false;
        }
        return bridges.get(index - 1);
    }

    public List<Boolean> getBridges() {
        return Collections.unmodifiableList(this.bridges);
    }
}
