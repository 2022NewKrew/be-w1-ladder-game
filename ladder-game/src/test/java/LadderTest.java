import domain.ladder.Ladder;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    static private final int TEST_NUMBER_OF_PEOPLE = 10;
    static private final int TEST_LADDER_HEIGHT = 10;

    @Test
    void constructorTest() {
        Ladder testLadder = new Ladder(TEST_NUMBER_OF_PEOPLE, TEST_LADDER_HEIGHT);
        assertThat(testLadder
                .getLadderFrameLineList()
                .size())
                .isEqualTo(TEST_LADDER_HEIGHT);
        assertThat(testLadder
                .getLadderFrameLineList()
                .get(0)
                .getLadderFrameList()
                .size())
                .isEqualTo(TEST_NUMBER_OF_PEOPLE - 1);
    }

}
