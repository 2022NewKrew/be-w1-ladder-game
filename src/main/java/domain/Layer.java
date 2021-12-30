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

    public void proceed(List<Integer> resultIndexes) {
        for (int horizontalLineIndex = 0; horizontalLineIndex < horizontalLines.size(); horizontalLineIndex++) {
            followHorizontalLine(resultIndexes, horizontalLineIndex);
        }
    }

    private void followHorizontalLine(List<Integer> resultIndexes, int index) {
        if (this.horizontalLines.get(index)) {
            int temp = resultIndexes.get(index);
            resultIndexes.set(index, resultIndexes.get(index + 1));
            resultIndexes.set(index + 1, temp);
        }
    }
}
