import domain.LadderRowData;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class LadderRowDataTest {
    private final Random random = new Random();

    @Test
    public void testRandomBooleanFalseIfPrevBooleanIsTrue() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = LadderRowData.class.getDeclaredMethod("generateRandomBoolean", Boolean.class, Random.class);
        method.setAccessible(true);
        Boolean randomBoolean = (Boolean) method.invoke(method, true, random);
        assertFalse(randomBoolean);
    }
}
