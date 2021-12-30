package ladder.domain;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

class LineTest {

    @Test
    void validCheckTest() throws Exception {
        Line line = new Line(5);

        Method method = line.getClass().getDeclaredMethod("validCheck", int.class);
        method.setAccessible(true);

        int result1 = (int) method.invoke(line, 0);
        assertEquals(result1, 1);
    }
}