package ladder.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LineTest {
    @Test
    @DisplayName("Should not create lines with invalid parameter (null)")
    void linesWithInvalidParameter() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Line(null));
    }
}
