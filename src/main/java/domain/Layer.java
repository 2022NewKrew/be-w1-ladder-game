package domain;

import java.util.List;

public class Layer {
    private final List<Boolean> horizontalLines;

    public Layer(List<Boolean> horizontalLines) {
        this.horizontalLines = horizontalLines;
    }

    public List<Boolean> getHorizontalLines() {
        return horizontalLines;
    }
}
