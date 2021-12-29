package domain;

import java.util.List;

public class Ladder {
    private final List<Layer> layers;

    public Ladder(List<Layer> layers) {
        this.layers = layers;
    }

    public List<Layer> getLayers () {
        return layers;
    }
}
