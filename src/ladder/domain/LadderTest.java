package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LadderTest {

    @Test
    void testGetPeopleNames() {
        ArrayList<String> peopleNames = new ArrayList<>(Arrays.asList("hello", "world"));
        Ladder ladder = new Ladder(peopleNames, 5);
        assertEquals(ladder.getPeopleNames(), peopleNames);
    }

    @Test
    void testGetLines() {
        ArrayList<String> peopleNames = new ArrayList<>(Arrays.asList("hello", "world"));
        Ladder ladder = new Ladder(peopleNames, 5);
        assertEquals(ladder.getLines().size(), 5);
    }
}
