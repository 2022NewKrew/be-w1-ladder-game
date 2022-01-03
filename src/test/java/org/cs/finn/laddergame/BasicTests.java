package org.cs.finn.laddergame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BasicTests {
    @Test
    @DisplayName("2 + 3은 5다")
    public void basicTest() {
      assertThat(2 + 3)
              .isEqualTo(5);
    }
}
