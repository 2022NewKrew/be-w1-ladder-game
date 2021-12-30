package laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    @DisplayName("Ladder 생성 테스트")
    @Test
    void of() {
        int numberOfPlayer = 5;
        int ladderHeight = 7;

        Ladder ladder = Ladder.of(numberOfPlayer, ladderHeight);

        assertThat(ladder.getLineList()).hasSize(ladderHeight);
    }
}