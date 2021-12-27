package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LadderTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4})
    @DisplayName("사다리를 생성한다.")
    void valueOf(int height) {
        // given
        int person = 3;
        Ladder ladder = Ladder.valueOf(person, height);

        // when
        List<Line> lines = ladder.getLines();

        // then
        assertThat(lines).hasSize(height);
    }
}
