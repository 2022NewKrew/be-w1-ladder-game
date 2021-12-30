package org.cs.finn.laddergame;

import org.assertj.core.api.Assertions;
import org.cs.finn.laddergame.util.Checker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class CheckerTests {
    @Test
    @DisplayName("Test 모듈 작동 확인")
    public void basicTest() {
      Assertions.assertThat(2 + 3)
              .isEqualTo(5);
    }

    @Test
    @DisplayName("Member 객체 검사")
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
