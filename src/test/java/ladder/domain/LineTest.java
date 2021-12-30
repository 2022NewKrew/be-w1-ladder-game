package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {

    @DisplayName("왼쪽 사다리가 있는 경우 테스트")
    @Test
    void hasLeftBridgeSuccess() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException {
        //given
        Line line = new Line();
        Field field = Line.class.getDeclaredField("bridges");
        field.setAccessible(true);
        List bridges = (List) field.get(line);

        Method method = Line.class.getDeclaredMethod("hasLeftBridge", int.class);
        method.setAccessible(true);

        //when
        bridges.add(true);
        boolean result = (boolean) method.invoke(line, 1);

        //then
        assertThat(result).isTrue();
    }

    @DisplayName("왼쪽 사다리가 없는 경우 테스트")
    @Test
    void hasLeftBridgeFail() throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        //given
        Line line = new Line();
        Field field = Line.class.getDeclaredField("bridges");
        field.setAccessible(true);
        List bridges = (List) field.get(line);

        Method method = Line.class.getDeclaredMethod("hasLeftBridge", int.class);
        method.setAccessible(true);

        //when
        bridges.add(false);
        boolean result = (boolean) method.invoke(line, 1);

        //then
        assertThat(result).isFalse();
    }
}