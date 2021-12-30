import model.Line;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.lang.reflect.Field;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LineTest {
    @Test
    void testToString() {
        Line line = new Line(5);
        assertNotNull(line.toString());
    }

    @Test
    void testLineContainsNull(){
        Line line = new Line(5);
        try{
            Field field = line.getClass().getDeclaredField("points");
            field.setAccessible(true);

            List<Boolean> testLadder = (List<Boolean>)field.get(line);
            testLadder.stream()
                    .forEach(Assertions::assertNotNull);

        }catch(NoSuchFieldException | IllegalAccessException e){
            e.printStackTrace();
        }
    }
}