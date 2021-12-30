package domain;

import java.util.Collections;
import java.util.List;

public class Ladder {
    private final List<Layer> layers;

    public Ladder(List<Layer> layers) {
        this.layers = Collections.unmodifiableList(layers);
    }

    public List<Layer> getLayers () {
        return layers;
    }
}
