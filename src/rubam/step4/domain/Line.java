package rubam.step4.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Line {

    private final Random random = new Random();
    private final List<Boolean> steps = new ArrayList<>();

    public Line(int people) {
        makeLine(people);
    }

    private void makeLine(int people) {
        steps.add(random.nextBoolean());
        for (int i = 1; i < people - 1; i++) {
            steps.add(makeNextStep(steps.get(i - 1)));
        }
    }

    private Boolean makeNextStep(Boolean step) {
        if (step)
            return false;
        return random.nextBoolean();
    }

    public List<Boolean> getStepsData() {
        return Collections.unmodifiableList(steps);
    }
}
