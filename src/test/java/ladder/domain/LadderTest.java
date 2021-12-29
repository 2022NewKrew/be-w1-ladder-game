package ladder.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderTest {
    @Test
    @DisplayName("Should not create ladders with invalid parameter (null)")
    void ShouldNotCreateLaddersWithInvalidParameter() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Ladder(null));
    }
}
