package org.cs.finn.laddergame.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CheckerTests {

    @Test
    @DisplayName("Checker 객체 검사")
    public void testChecker() {
        // then
        Assertions.assertThatThrownBy(() -> Checker.checkIntMinMaxInit(1, 2, 3))
                .isInstanceOf(IllegalStateException.class);
        Assertions.assertThatThrownBy(() -> Checker.checkIntMinMaxInit(2, 3, 1))
                .isInstanceOf(IllegalStateException.class);
        Assertions.assertThatThrownBy(() -> Checker.checkIntMinMaxInit(4, 2, 3))
                .isInstanceOf(IllegalStateException.class);

        Assertions.assertThatThrownBy(() -> Checker.checkIntBound(1, 2, 3))
                .isInstanceOf(IndexOutOfBoundsException.class);
        Assertions.assertThatThrownBy(() -> Checker.checkIntBound(4, 2, 3))
                .isInstanceOf(IndexOutOfBoundsException.class);
        Assertions.assertThatThrownBy(() -> Checker.checkIntBound(1, 2, 3))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }
}
