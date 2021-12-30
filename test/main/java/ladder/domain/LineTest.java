package main.java.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.IntStream;

import static main.java.ladder.domain.LadderComponent.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("사다리 행 생성 테스트")
class LineTest {

    @Test
    void 사다리의_가로선은_연속되지_않는다() throws NoSuchFieldException, IllegalAccessException {
        //given
        int widthOfLadder = 11;
        Line line = new Line(widthOfLadder);

        Field field = line.getClass().getDeclaredField("points");
        field.setAccessible(true);
        List<LadderComponent> points = (List<LadderComponent>) field.get(line);

        //when
        boolean isSuccessive = IntStream.range(2, widthOfLadder)
                .anyMatch(i -> points.get(i) == HORIZONTAL && points.get(i - 2) == HORIZONTAL);

        //then
        assertFalse(isSuccessive);
    }
}