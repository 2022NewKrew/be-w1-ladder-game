package rubam.test.step5;

import org.junit.jupiter.api.Test;
import rubam.step5.domain.Line;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    @Test
    void getStepsDataTest() {
        // given
        int people = 7;

        // when
        Line line = new Line(people);

        // then
        assertThat(line.getStepsData().size()).isEqualTo(people - 1);
    }

    @Test
    void serializedStepCheckTest() {
        // given
        int people = 7;

        // when
        Line line = new Line(people);

        // then
        boolean before = false;
        for (Boolean b : line.getStepsData()) {
            if (before)
                assertThat(b).isEqualTo(false);
            before = b;
        }
    }
}
