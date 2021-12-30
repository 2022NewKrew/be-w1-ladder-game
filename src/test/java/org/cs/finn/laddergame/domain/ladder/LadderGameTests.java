package org.cs.finn.laddergame.domain.ladder;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderGameTests {

    @Test
    @DisplayName("LadderHeight 객체 검사")
    public void testLadderHeight() {
        // given
        final int value = 10;
        final LadderHeight ladderHeight = new LadderHeight(String.valueOf(value));

        // then
        Assertions.assertThatThrownBy(() -> new LadderHeight(null))
                .isInstanceOf(RuntimeException.class);
        Assertions.assertThatThrownBy(() -> new LadderHeight("test"))
                .isInstanceOf(NumberFormatException.class);
        Assertions.assertThatThrownBy(() -> new LadderHeight("100"))
                .isInstanceOf(IndexOutOfBoundsException.class);

        Assertions.assertThat(ladderHeight.getLadderHeight())
                .isEqualTo(value);
    }
}
