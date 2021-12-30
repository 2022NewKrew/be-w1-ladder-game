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

    public void proceed(List<Integer> participantIndices) {
        for (int horizontalLineIndex = 0; horizontalLineIndex < horizontalLines.size(); horizontalLineIndex++) {
            followHorizontalLine(participantIndices, horizontalLineIndex);
        }
    }

    private void followHorizontalLine(List<Integer> participantIndices, int index) {
        if (this.horizontalLines.get(index)) {
            int temp = participantIndices.get(index);
            participantIndices.set(index, participantIndices.get(index + 1));
            participantIndices.set(index + 1, temp);
        }
    }
}
