package domain;

import org.junit.jupiter.api.Test;
import view.LadderRenderer;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

class LadderLineTest {
    LadderLine ladderLine = new LadderLine(5);

    @Test
    void addPointWhenLastPointIsTrue() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Boolean expected = false;

        Method method = LadderLine.class.getDeclaredMethod("addPoint", Boolean.class);
        method.setAccessible(true);
        Boolean actual = (Boolean) method.invoke(ladderLine, true);

        assertEquals(expected, actual);
    }
}