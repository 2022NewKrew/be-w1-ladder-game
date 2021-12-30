package ladder.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class LadderTest {

//    @Test
//    void makeLadder() {
//    }
//
//    @Test
//    void testToString() {
//    }
    @Test
    void writeNamesNormalTest() {
        String peopleString = "pobi,honux,crong,jk";
        Ladder ladder = new Ladder(4, 5, peopleString);
        ladder.writeNames();
        Assertions.assertEquals("pobi  honux crong  jk   \n", ladder.getCurrentString());
    }
    @Test
    void writeNamesLongNameTest() {
        String peopleString = "pineapple,blueberry,banana,pear";
        Ladder ladder = new Ladder(4, 5, peopleString);
        ladder.writeNames();
        Assertions.assertEquals("pinea blueb banan pear  \n", ladder.getCurrentString());
    }
}