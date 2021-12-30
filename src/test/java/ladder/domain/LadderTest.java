package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class LadderTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4})
    @DisplayName("사다리를 생성한다.")
    void valueOf(int ladderHeight) {
        // given
        int countOfPerson = 3;
        Ladder ladder = Ladder.valueOf(countOfPerson, ladderHeight);

        // when
        List<Line> lines = ladder.getLines();

        // then
        assertThat(lines).hasSize(ladderHeight);
    }

    @Test
    @DisplayName("(생성자) 사다리 높이가 0 이하라면 에러가 발생한다.")
    void createWithLessThenZero() {
        // given

        // when
        ThrowingCallable callable = () -> new Ladder(new ArrayList<>());

        // then
        assertThatThrownBy(callable).isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, -999})
    @DisplayName("(정적팩터리메서드) 사다리 높이가 0 이하라면 에러가 발생한다.")
    void valueOfWithEmpty(int ladderHeight) {
        // given
        int countOfPerson = 3;

        // when
        ThrowingCallable callable = () -> Ladder.valueOf(countOfPerson, ladderHeight);

        // then
        assertThatThrownBy(callable).isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"0:1", "1:0", "2:3", "3:2", "4:4"}, delimiter = ':')
    @DisplayName("사다리의 결과를 확인한다.")
    void foundResult(int startPoint, int expected) {
        // given
        List<Line> lines = new ArrayList<>();


        lines.add(new Line(Arrays.asList(true, false, true, false, false)));
        lines.add(new Line(Arrays.asList(false, true, false, true, false)));
        lines.add(new Line(Arrays.asList(false, true, false, true, false)));

        Ladder ladder = new Ladder(lines);

        // when
        int result = ladder.foundResult(startPoint);

        // then
        assertThat(result).isEqualTo(expected);
    }
}
