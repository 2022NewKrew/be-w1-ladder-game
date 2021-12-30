package org.cs.finn.laddergame.domain.ladder;

import java.util.List;

public final class LadderRows {
    private final List<LadderRow> list;

    public LadderRows(final List<LadderRow> list) {
        if (list == null || list.isEmpty()) {
            throw new RuntimeException("List<LadderRow> is null or empty!");
        }
        this.list = List.copyOf(list);
    }

    public List<LadderRow> getList() {
        return list;
    }
}
