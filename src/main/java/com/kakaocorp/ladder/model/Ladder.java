package com.kakaocorp.ladder.model;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final int height;
    private final List<Stick> sticks;

    public Ladder(int height, int width) {
        this.height = height;
        sticks = new ArrayList<>(width);
        for (int i = 0; i < width; i++) {
            sticks.add(new Stick(height));
        }
    }

    public List<Stick> getSticks() {
        return sticks;
    }

    public int getHeight() {
        return height;
    }
}
