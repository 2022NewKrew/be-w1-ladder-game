package com.kakaocorp.ladder.model;

import java.util.ArrayList;
import java.util.List;

public class Rail {

    private final List<Node> nodes;
    private final String label;

    public Rail(String label, int height) {
        this.label = label;
        nodes = new ArrayList<>(height);
        for (int i = 0; i < height; i++) {
            nodes.add(new Node());
        }
    }

    public Node getNodeAt(int index) {
        return nodes.get(index);
    }

    public String getLabel() {
        return label;
    }
}
