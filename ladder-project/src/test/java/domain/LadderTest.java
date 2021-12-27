package domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LadderTest {

    @Test
    void generateLineTest() {
        //given
        int column = 3;
        int height = 5;
        Ladder ladder = new Ladder(column, height);

        //then
        assertNotEquals(-1, ladder.getLine());
    }

}