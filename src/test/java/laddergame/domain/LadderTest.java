package laddergame.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class LadderTest {

    @DisplayName("사다리 생성 테스트")
    @Test
    void makeLadder() {
        // Given
        Ladder ladder = new Ladder(5, 4);

        // When
        List<List<LadderComponent>> result = ladder.makeLadder(5, 4);

        // Then
        Assertions.assertEquals(result.size(), 4);
        Assertions.assertEquals(result.get(0).size(), 5);
    }

    @DisplayName("getLadder 메소드 테스트")
    @Test
    void getLadder() {
        // Given
        Ladder ladder = new Ladder(5, 4);

        // When
        List<List<LadderComponent>> result = ladder.getLadder();

        // Then
        Assertions.assertEquals(result.size(), 4);
        Assertions.assertEquals(result.get(0).size(), 5);
    }
}