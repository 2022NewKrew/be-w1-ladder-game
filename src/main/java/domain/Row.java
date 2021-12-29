package domain;

import java.util.Collections;
import java.util.List;

public class Row {
    private final List<Boolean> bridges;

    public Row(List<Boolean> bridges) {
        this.bridges = bridges;
    }

    public List<Boolean> getBridges() {
        return Collections.unmodifiableList(bridges);
    }
}