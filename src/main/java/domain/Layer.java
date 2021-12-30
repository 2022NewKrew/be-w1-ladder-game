package domain;

import java.util.Collections;
import java.util.List;

public class Layer {
    private final List<Boolean> horizontalLines;

    public Layer(List<Boolean> horizontalLines) {
        this.horizontalLines = Collections.unmodifiableList(horizontalLines);
    }

    public List<Boolean> getHorizontalLines() {
        return horizontalLines;
    }
}
