import java.util.ArrayList;
import java.util.Random;

/**
 * {@link Ladder}의 가로 한 줄을 담당하는 클래스
 */
public class LadderRow {
    private enum StepType {
        EMPTY("    "),
        STEP("----");

        private final String displayStr;
        private static final Random random = new Random();

        StepType(String displayStr) {
            this.displayStr = displayStr;
        }

        public static StepType getRandomStep() {
            int size = values().length;
            return values()[random.nextInt(size)];
        }

        @Override
        public String toString() {
            return displayStr;
        }
    }

    private final ArrayList<StepType> steps = new ArrayList<>();
    private final String poleStr = "|";

    LadderRow(int numOfPeople) {
        for (int i=0; i<numOfPeople; ++i) {
            steps.add(decideNextStep());
        }
    }

    /**
     * 다음 step에 발판이 들어와야 하는지 결정하는 함수
     * <p>|----|----| 처럼 가로가 겹치지 않게 한다
     */
    private StepType decideNextStep() {
        if (steps.isEmpty() || steps.get(steps.size() - 1) == StepType.EMPTY) {
            return StepType.getRandomStep();
        }
        return StepType.EMPTY;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (StepType step : steps) {
            sb.append(poleStr);
            sb.append(step);
        }
        sb.append(poleStr);
        return sb.toString();
    }
}
