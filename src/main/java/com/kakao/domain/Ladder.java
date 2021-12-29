package com.kakao.domain;

import java.util.Collections;
import java.util.List;

public class Ladder {

    private final List<Line> lines;

    public Ladder(List<Line> lines) {
        this.lines = Collections.unmodifiableList(lines);
    }

    public List<Line> getLines() {
        return lines;
    }
}
