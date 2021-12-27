package com.kakaocorp.ladder.model;

import java.util.ArrayList;
import java.util.List;

public class Stick {

    private final List<Node> nodes;

    public Stick(int height) {
        nodes = new ArrayList<>(height);
        for (int i = 0; i < height; i++) {
            nodes.add(new Node());
        }
    }

    public List<Node> getNodes() {
        return nodes;
    }
}
