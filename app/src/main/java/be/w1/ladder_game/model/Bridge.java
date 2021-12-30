package be.w1.ladder_game.model;

import java.util.ArrayList;
import java.util.List;

public class Bridge {
    private final int width;
    List<Boolean> edges = new ArrayList<>();

    public Bridge(int width) {
        this.width = width;

        for (int i = 0; i < width; ++i) {
            edges.add(false);
        }

    }

    public List<Boolean> getEdges() {
        return edges;
    }
}
