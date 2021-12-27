package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
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

    @ParameterizedTest
    @ValueSource(ints = {0, -1, -999})
    @DisplayName("(정적팩토리메소드) 인원이 0명 이하라면 에러가 발생한다.")
    void valueOfWithLessThenZero(int countOfPerson) {
        // given

        // when
        ThrowingCallable callable = () -> valueOf(countOfPerson);

        // then
        assertThatThrownBy(callable).isExactlyInstanceOf(IllegalArgumentException.class);
    }
}
