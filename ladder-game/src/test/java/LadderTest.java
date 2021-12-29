import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LadderTest {

    static private final int TEST_NUMBER_OF_PEOPLE = 10;
    static private final int TEST_LADDER_HEIGHT = 10;

    @Test
    void consturctor() {
        Ladder testLadder = new Ladder(TEST_NUMBER_OF_PEOPLE, TEST_LADDER_HEIGHT);
        assertThat(testLadder.getShape().size()).isEqualTo(TEST_LADDER_HEIGHT);
        assertThat(testLadder.getShape().get(0).length()).isEqualTo(TEST_NUMBER_OF_PEOPLE);
    }

}
