package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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

    @Test
    @DisplayName("이전에 사다리가 그려졌다면 다음은 true 일 수 없다.")
    void nextRandomBooleanWithBeforeTrue()
        throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // given
        Class<Line> lineClass = Line.class;
        Method method = lineClass.getDeclaredMethod("nextRandomBoolean", boolean.class);
        method.setAccessible(true);

        // when
        boolean value = (boolean) method.invoke(null, true);

        // then
        assertThat(value).isFalse();
    }

    @Test
    @DisplayName("이전에 사다리가 안그려졌다면 true or false 가 나온다.")
    void nextRandomBooleanWithBeforeFalse()
        throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<Line> lineClass = Line.class;
        Method method = lineClass.getDeclaredMethod("nextRandomBoolean", boolean.class);
        method.setAccessible(true);

        // when
        Set<Boolean> booleans = new HashSet<>();
        for (int i = 0; i < 100; i++) {
            booleans.add((boolean) method.invoke(null, false));
        }

        // then
        assertThat(booleans).hasSize(2);
    }
}
