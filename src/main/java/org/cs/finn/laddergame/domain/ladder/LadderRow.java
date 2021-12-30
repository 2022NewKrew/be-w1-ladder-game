package org.cs.finn.laddergame.domain.ladder;

import java.util.List;

public class LadderRow {
    private final List<BridgeType> list;

    public LadderRow(final List<BridgeType> list) {
        if (list == null || list.isEmpty()) {
            throw new RuntimeException("List<BridgeType> is null or empty!");
        }
        this.list = List.copyOf(list);
    }

    public List<BridgeType> get() {
        return list;
    }

}
