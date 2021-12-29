package com.chanminkim.w1.model;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<LadderLine> map = new ArrayList<>();

    public void appendLine(LadderLine line) {
        map.add(line);
    }

    public List<LadderLine> getMap() {
        return map;
    }
}
