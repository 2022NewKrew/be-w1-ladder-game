package org.cs.finn.laddergame.domain;

import org.assertj.core.api.Assertions;
import org.cs.finn.laddergame.domain.ladder.LadderHeight;
import org.cs.finn.laddergame.domain.stringvalues.Members;
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
        final Members members = Members.getDefault();
        final Ladder ladder = new Ladder(secureRandom, ladderHeight, members);
        // when

        // then
        Assertions.assertThatThrownBy(() -> new Ladder(null, ladderHeight, members))
                .isInstanceOf(RuntimeException.class);
        Assertions.assertThatThrownBy(() -> new Ladder(secureRandom, null, members))
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
                ).isEqualTo(Members.INIT - 1);
    }
}
