package ladderGame.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LadderLineTest {
    private static final int TEST_LADDER_HEIGHT = 10;
    private static final int TEST_PLAYER_COUNT = 5;

    @Test
    void makeLadderLine() {
        final int testLadderWidth = TEST_PLAYER_COUNT - 1;

        final Ladder ladder = Ladder.makeLadder(TEST_LADDER_HEIGHT, testLadderWidth);

        assertEquals(TEST_LADDER_HEIGHT, ladder.getLadderLines().size());
        assertEquals(testLadderWidth, ladder.getLadderLines().get(0).getladderLineBranchs().size());
    }
}
