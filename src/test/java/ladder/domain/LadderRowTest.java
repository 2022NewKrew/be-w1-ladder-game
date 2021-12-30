package ladder.domain;

import static ladder.domain.LadderType.BRIDGE;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import static ladder.domain.LadderType.BLANK;
import static org.junit.jupiter.api.Assertions.*;

class LadderRowTest {

    @Test
    void decideElementTest() throws NoSuchMethodException, NoSuchFieldException, IllegalAccessException, InvocationTargetException {
        LadderRow ladderRow = new LadderRow(0);
        Field field = ladderRow.getClass().getDeclaredField("elementList");
        field.setAccessible(true);
        Method method = ladderRow.getClass().getDeclaredMethod("decideElement");
        method.setAccessible(true);

        ArrayList<LadderType> elementList = (ArrayList<LadderType>) field.get(ladderRow);
        elementList.add(BRIDGE);
        LadderType resultType = (LadderType) method.invoke(ladderRow);

        assertThat(BLANK).isEqualTo(resultType);
        //assertEquals("BLANK" ,resultType.name());

    }
}