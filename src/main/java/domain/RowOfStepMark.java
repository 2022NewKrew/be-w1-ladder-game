package domain;


import util.Random;
import java.util.ArrayList;
import java.util.List;


public class RowOfStepMark {
    private final List<Boolean> state;

    public RowOfStepMark(int width) {
        state = new ArrayList<>();
        boolean isStepAvailable = true;

        for (int col = 0; col < width; col++) {
            boolean isStep = isStepAvailable && Random.nextBoolean();
            state.add(isStep);
            isStepAvailable = !isStep;
        }
    }

    public List<Boolean> getState() {
        return state;
    }

    @Override
    public String toString() {
        return "RowOfStepMark{" +
                "state=" + state +
                '}';
    }
}
