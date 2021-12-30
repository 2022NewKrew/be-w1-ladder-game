package org.cs.finn.laddergame.domain;

import org.assertj.core.api.Assertions;
import org.cs.finn.laddergame.domain.ladder.LadderHeight;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.security.SecureRandom;

public class LadderTests {
    private final SecureRandom secureRandom = new SecureRandom();

    @Test
    @DisplayName("Ladder 객체 검사")
    @SuppressWarnings("all")
    public void testLadder() {
        // given
        final LadderHeight ladderHeight = LadderHeight.getDefault();
        final Member member = Member.getDefault();
        final Ladder ladder = new Ladder(secureRandom, ladderHeight, member);
        // when

        // then
        Assertions.assertThatThrownBy(() -> new Ladder(null, ladderHeight, member))
                .isInstanceOf(RuntimeException.class);
        Assertions.assertThatThrownBy(() -> new Ladder(secureRandom, null, member))
                .isInstanceOf(RuntimeException.class);
        Assertions.assertThatThrownBy(() -> new Ladder(secureRandom, ladderHeight, null))
                .isInstanceOf(RuntimeException.class);

        Assertions.assertThat(
                ladder.getLadderRows()
                        .getLadderRowList()
                        .size()
                ).isEqualTo(LadderHeight.INIT);
        Assertions.assertThat(
                ladder.getLadderRows()
                        .getLadderRowList()
                        .get(0)
                        .getBridgeList()
                        .size()
                ).isEqualTo(Member.INIT - 1);
    }
}
