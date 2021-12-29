package org.cs.finn.laddergame.domain.ladder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class LadderRows {
    private final List<String> list = new ArrayList<>();

    public void add(String ladderRow) {
        if (ladderRow != null && !ladderRow.isBlank()) {
            list.add(ladderRow);
        }
    }

    public List<String> get() {
        return Collections.unmodifiableList(list);
    }
}
