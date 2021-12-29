package com.kakaocorp.ladder.model;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final int height;
    private final List<Rail> rails;

    public Ladder(int height, int width) {
        this.height = height;
        rails = new ArrayList<>(width);
        for (int i = 0; i < width; i++) {
            rails.add(new Rail(height));
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
