package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class StepGeneratorTest {

    /**
     * 왼쪽 step이 있으면 무조건 EMPTY {@link Step}이 나오는지 확인
     */
    @Test
    void getNextStep() {
        // given
        boolean isLeftStepFilled = true;

        // when
        Step nextStep = StepGenerator.getNextStep(isLeftStepFilled);

        // then
        assertThat(nextStep).isEqualTo(Step.EMPTY);
    }
}