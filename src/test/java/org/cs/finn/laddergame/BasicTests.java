package org.cs.finn.laddergame;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BasicTests {
    @Test
    @DisplayName("Test 모듈 작동 확인")
    public void basicTest() {
      Assertions.assertThat(2 + 3)
              .isEqualTo(5);
    }
}
