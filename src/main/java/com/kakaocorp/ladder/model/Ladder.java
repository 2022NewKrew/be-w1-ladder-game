package com.kakaocorp.ladder.model;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final int height;
    private final List<Rail> rails;

    public Ladder(int height, String[] participants) {
        this.height = height;
        int width = participants.length;
        rails = new ArrayList<>(width);
        for (String participant : participants) {
            rails.add(new Rail(participant, height));
        }
    }

    public Rail getRailAt(int index) {
        return rails.get(index);
    }

    public int getWidth() {
        return rails.size();
    }

    public int getHeight() {
        return height;
    }
}
