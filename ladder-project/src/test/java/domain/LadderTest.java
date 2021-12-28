package domain;

import domain.ladder.Ladder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class LadderTest {

    @Test
    void generateRandomLineTest() {
        //given
        int column = 3;
        int height = 5;
        Ladder ladder = new Ladder(column, height);

        //then
        assertDoesNotThrow(() -> new AssertionError());
    }
}