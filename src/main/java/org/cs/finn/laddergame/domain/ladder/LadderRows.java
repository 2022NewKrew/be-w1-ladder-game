package org.cs.finn.laddergame.domain.ladder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class LadderRows {
    private final List<LadderRow> list;

    public LadderRows(final List<LadderRow> list) {
        if (list == null || list.isEmpty()) {
            throw new RuntimeException("List<LadderRow> is null or empty!");
        }
        this.list = new ArrayList<>(list);
    }

    public List<LadderRow> getLadderRowList() {
        return Collections.unmodifiableList(list);
    }
}
