package repository;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LadderTest {

    @Test
    public void getMaxResultLengthTest(){
        List<String> results = new ArrayList<>();
        results.add("eroica.b");
        results.add("kina.lee");
        results.add("iron.man");
        results.add("tony.stark");
        results.add("Thor.odinson");
        results.add("black.widow");
        results.add("captain.america");
        int max_length = new Ladder(0, new ArrayList<>(), results).getMaxResultLength();
        int expected = 15;
        assertEquals(expected, max_length);
    }
}