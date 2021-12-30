package domain;

import java.util.Collections;
import java.util.List;

public class Line {
    private final List<Boolean> bridges;

    public Line(List<Boolean> bridges) {
        this.bridges = bridges;
    }

    public List<Boolean> getBridges() {
        return Collections.unmodifiableList(bridges);
    }

    public boolean existLeftBridge(int location) {
        if (location == 0)
            return false;
        return bridges.get(location - 1);
    }

    public boolean existRightBridge(int location) {
        if (location == bridges.size())
            return false;
        return bridges.get(location);
    }
}