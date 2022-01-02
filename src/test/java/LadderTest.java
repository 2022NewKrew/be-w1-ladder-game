import model.Ladder;
import model.Line;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LadderTest {

    @Test
    void testToString() {
        List<String> namePeople = new ArrayList<>();
        namePeople.add("ben");
        namePeople.add("jake");
        namePeople.add("creed");
        namePeople.add("kina");
        namePeople.add("pug");

        Ladder ladder = new Ladder(namePeople, 5, 5);
        assertNotNull(ladder);
    }

    @Test
    void testLadderContainsNull(){
        List<String> namePeople = new ArrayList<>();
        namePeople.add("ben");
        namePeople.add("jake");
        namePeople.add("creed");
        namePeople.add("kina");
        namePeople.add("pug");

        Ladder ladder = new Ladder(namePeople, 5, 5);
        try{
            Field field = ladder.getClass().getDeclaredField("ladder");
            field.setAccessible(true);

            List<Line> testLadder = (List<Line>)field.get(ladder);
            testLadder.stream()
                    .forEach(Assertions::assertNotNull);

        }catch(NoSuchFieldException | IllegalAccessException e){
            e.printStackTrace();
        }
    }
}