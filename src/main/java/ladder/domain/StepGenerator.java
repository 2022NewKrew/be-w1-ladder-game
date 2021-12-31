package ladder.domain;

import java.util.Random;

public class StepGenerator {
    private static final Random random = new Random();

    /**
     * 다음에 들어갈 {@link Step}을 반환하는 함수
     * <p>|----|----| 처럼 가로가 겹치지 않게 한다
     */
    public static Step getNextStep(boolean isLeftStepFilled) {
        if (isLeftStepFilled || random.nextBoolean()) {
            return Step.EMPTY;
        }
        return Step.FILLED;
    }
}
