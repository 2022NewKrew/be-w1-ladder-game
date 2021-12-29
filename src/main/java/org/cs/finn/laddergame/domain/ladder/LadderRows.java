package org.cs.finn.laddergame.domain.ladder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class LadderRows {
    private final List<LadderRow> list = new ArrayList<>();

    public void add(LadderRow ladderRow) {
        if (ladderRow == null) {
            throw new RuntimeException("LadderRow is null!");
        }
        list.add(ladderRow);
    }

    public List<LadderRow> get() {
        return Collections.unmodifiableList(list);
    }
}
