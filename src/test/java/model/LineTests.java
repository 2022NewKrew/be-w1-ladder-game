package model;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LineTests {
    @Test
    void canConnectTest(){
        Ladder.Line line = new Ladder.Line(5);

        List<Boolean> lineList = new ArrayList<>();
        try {
            Method method = line.getClass().getDeclaredMethod("canConnect", int.class);
            method.setAccessible(true);
            Boolean ret = (Boolean) method.invoke(line, 0);
            assertEquals(true, ret);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
