package ladder.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderBuilderTest {
    @Test
    @DisplayName("Should not create line builder with invalid parameter (numberOfPlayer is zero)")
    void ShouldNotCreateLineBuildersWithInvalidPlayerNumber() {
        int numberOfPlayer = 0;
        int height = 10;

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new LadderBuilder(numberOfPlayer, height));
    }

    @Test
    @DisplayName("Should not create line builder with invalid parameter (height is zero)")
    void ShouldNotCreateLineBuildersWithInvalidHeight() {
        int numberOfPlayer = 10;
        int height = 0;

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new LadderBuilder(numberOfPlayer, height));
    }
}
