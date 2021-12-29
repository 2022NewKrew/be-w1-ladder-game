package com.chanminkim.w1.model;

public class Ladder {
    private final LadderState[][] map;

    public Ladder(LadderState[][] map) {
        this.map = map;
    }

    public LadderState[][] getMap() {
        return map;
    }
}
