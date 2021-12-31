package ladder.view;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class PointGeneratorTest {

    @Test
    public void 선_그리기_판단_테스트() {
        // given
        PointGenerator pointGenerator = new PointGenerator();

        // when
        List<Boolean> points = List.of(Boolean.TRUE);

        // then
        Boolean testBoolean = pointGenerator.appendPoint(points);
        Assertions.assertThat(testBoolean).isFalse(); // TRUE 뒤에 추가되는 점은 무조건 FALSE 여야 함
    }
}