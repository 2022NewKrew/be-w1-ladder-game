package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * {@link Ladder}의 가로 한 줄을 담당하는 클래스
 */
public class LadderRow {
    private final List<Step> steps = new ArrayList<>();

    LadderRow(int numOfPeople) {
        for (int i = 0; i < numOfPeople - 1; ++i) {
            boolean isleftFilled = (i != 0 && steps.get(steps.size() - 1) == Step.FILLED);
            steps.add(StepGenerator.generateNextStep(isleftFilled));
        }
    }

    public List<Step> getSteps() {
        return Collections.unmodifiableList(steps);
    }
}
