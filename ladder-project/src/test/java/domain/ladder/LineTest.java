package domain.ladder;

import domain.ladder.line.Line;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class LineTest {

    @Test
    @DisplayName("라인 생성 테스트")
    void lineCreateTest() {
        //given
        List<Boolean> testLine = Arrays.asList(false, true, false);

        //when
        Line line = Line.createToStrategy((column) -> testLine, 3);
        List<Boolean> result = line.getLines();

        //then
        assertList(testLine, result);
    }

    @Test
    @DisplayName("라인 중복 테스트")
    void linePositionTest() {
        //given
        List<Boolean> testLine = Arrays.asList(false, true, true);
        List<Boolean> expected = Arrays.asList(false, true, false);

        //when
        Line line = Line.createToStrategy((column) -> testLine, testLine.size());

        //then
        assertList(expected, line.getLines());
    }

    void assertList(List<Boolean> expected, List<Boolean> actual) {
        for (int i = 0; i < expected.size(); i++) {
            Assertions.assertEquals(expected.get(i), actual.get(i));
        }
    }
}
