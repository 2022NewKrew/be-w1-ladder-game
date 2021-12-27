package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LineTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4})
    @DisplayName("Line 을 생성한다.")
    void valueOf(int person) {
        // given
        Line line = Line.valueOf(person);

        // when
        List<Boolean> points = line.getPoints();

        // then
        assertThat(points).hasSize(person - 1);
    }

}
