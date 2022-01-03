package domain;


import java.util.ArrayList;
import java.util.List;


public class Ladder {
    private final int width, height;
    private List<RowOfStepMark> state;

    Ladder(int width, int height) {
        this.width = width;
        this.height = height;
        this.makeLadder();
    }

    public List<RowOfStepMark> getState() {
        return state;
    }

    @Override
    public String toString() {
        return "Ladder{" +
                "width=" + width +
                ", height=" + height +
                ", state=" + state +
                '}';
    }

    private void makeLadder() {
        state = new ArrayList<>();

        for (int row = 0; row < height; row++) {
            state.add(new RowOfStepMark(width - 1));
        }
    }
}
