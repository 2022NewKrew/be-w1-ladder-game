package ladder.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class RandomBridgeBuilderTest {

    @Test
    void getRandomLadderRow() {
        // given
        final RandomBridgeBuilder randomBridgeBuilder = new RandomBridgeBuilder();

        // when
        final List<Boolean> randomLadderRow = randomBridgeBuilder.getRandomLadderRow(5);

        // then
        for (int idx = 0; idx < randomLadderRow.size() - 1; idx++) {
            Assertions.assertFalse(randomLadderRow.get(idx) && randomLadderRow.get(idx + 1), "Invalid Ladder Row");
        }
    }
}