package main.java.ladder.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.stream.IntStream;

import static main.java.ladder.domain.LadderComponent.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("사다리 행 생성 테스트")
class LineTest {

    static Line line;
    static final int WIDTH_OF_LADDER = 11;

    @BeforeAll
    static void init() {
        line = new Line(WIDTH_OF_LADDER);
    }

    @Test
    void 사다리의_가로선은_연속되지_않는다() throws NoSuchFieldException, IllegalAccessException {
        //given
        Field field = line.getClass().getDeclaredField("points");
        field.setAccessible(true);
        List<LadderComponent> points = (List<LadderComponent>) field.get(line);

        //when
        boolean isSuccessive = IntStream.range(2, WIDTH_OF_LADDER)
                .anyMatch(i -> points.get(i) == HORIZONTAL && points.get(i - 2) == HORIZONTAL);

        //then
        assertFalse(isSuccessive);
    }

    @Test
    void 열_인덱스가_짝수면_세로선() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //given
        Method method = line.getClass().getDeclaredMethod("fillLine", int.class);
        method.setAccessible(true);

        //when
        LadderComponent result = (LadderComponent) method.invoke(line, 0);

        //then
        assertEquals(VERTICAL, result);
    }

    @Test
    void 열_인덱스가_홀수면_가로선_또는_공백() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //given
        Method method = line.getClass().getDeclaredMethod("fillLine", int.class);
        method.setAccessible(true);

        //when
        LadderComponent result = (LadderComponent) method.invoke(line, 1);

        //then
        assertTrue(result == HORIZONTAL || result == EMPTY);
    }
}