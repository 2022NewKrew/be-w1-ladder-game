package com.chanminkim.w1.model;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<LadderLine> lines = new ArrayList<>();

    public void appendLine(LadderLine line) {
        lines.add(line);
    }

    public List<LadderLine> getLines() {
        return lines;
    }
}
