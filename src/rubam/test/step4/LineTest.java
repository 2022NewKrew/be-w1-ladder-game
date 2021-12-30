package rubam.test.step4;

import org.junit.jupiter.api.Test;
import rubam.step4.domain.Line;

import static org.assertj.core.api.Assertions.*;

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
}
