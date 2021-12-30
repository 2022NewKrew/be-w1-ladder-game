package domain.ladder;

import domain.ladder.Ladder;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    private static final int TEST_NUMBER_OF_PEOPLE = 10;
    private static final int TEST_LADDER_HEIGHT = 10;

    @Test
    void constructorTest() {
        Ladder testLadder = new Ladder(TEST_NUMBER_OF_PEOPLE, TEST_LADDER_HEIGHT);
        assertThat(testLadder
                .getLines()
                .size())
                .isEqualTo(TEST_LADDER_HEIGHT);
        assertThat(testLadder
                .getLines()
                .get(0)
                .getFrames()
                .size())
                .isEqualTo(TEST_NUMBER_OF_PEOPLE - 1);
    }
}
