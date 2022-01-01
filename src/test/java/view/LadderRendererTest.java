package view;

import DTO.InputDTO;
import DTO.OutputDTO;
import domain.Ladder;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class LadderRendererTest {
    InputDTO inputDTO = new InputDTO(
            Arrays.asList("hokey", "pokey", "longname", "sh", "s"),
            Arrays.asList("50000","X","X","X","3000"),
            7
    );
    Ladder ladder = new Ladder(inputDTO);
    OutputDTO outputDTO = new OutputDTO(ladder);
    LadderRenderer ladderRenderer = new LadderRenderer(outputDTO);

    @Test
    void printItemLessThanFiveLetters() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        String expected = "hokey";

        Method method = LadderRenderer.class.getDeclaredMethod("printItem", String.class);
        method.setAccessible(true);
        String actual = (String) method.invoke(ladderRenderer, "hokey");

        assertEquals(expected, actual);
    }

    @Test
    void printItemMoreThanFiveLetters() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        String expected = "longl";

        Method method = LadderRenderer.class.getDeclaredMethod("printItem", String.class);
        method.setAccessible(true);
        String actual = (String) method.invoke(ladderRenderer, "longlong");

        assertEquals(expected, actual);
    }
}