package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LineTest {

    @Test
    void testCheckDuplicatedLine() {
        Line line = new Line(5);
        line.test_checkDuplicatedLine();
    }

    @Test
    void testPointsSize() {
        Line line = new Line(5);
        assertEquals(line.getPoints().size(), 4);
    }
}
