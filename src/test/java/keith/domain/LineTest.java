package keith.domain;

import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.*;

public class LineTest {
    private static Line line;

    @Test
    void testZeroWidthLine() {
        line = new Line(0);
        assertThat(line.getPoints().size()).isEqualTo(2);
    }

    @Test
    void testMultiWidthLine() {
        for (int i = 1; i < 50; i++) {
            line = new Line(i);
            assertThat(line.getPoints().size()).isEqualTo(i + 1);
        }
    }
}
