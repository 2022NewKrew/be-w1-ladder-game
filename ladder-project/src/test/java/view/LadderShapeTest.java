package view;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LadderShapeTest {

    @Test
    void createTest() {
        //given
        List<List<Boolean>> list = new ArrayList<>();
        for(int i = 0; i < 2; i++) {
            List<Boolean> list2 = new ArrayList<>(2);
            list2.add(false);
            list2.add(false);
            list.add(list2);
        }
        list.get(0).set(1, true);
        list.get(1).set(0, true);
        String expected = ("|     |-----|\n|-----|     |\n");

        //when
        LadderShape result = LadderShape.create(list);

        //then
        assertEquals(expected, result.getShape());
    }
}