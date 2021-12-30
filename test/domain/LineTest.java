package domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LineTest {

    @Test
    void getPoints() {
        final int MAX_PARTICIPANTS_NUMBER = 1000;
        Line line = new Line(MAX_PARTICIPANTS_NUMBER);
        List<Boolean> points = line.getPoints();
        for (int i = 1; i < line.getLength(); i++) {
            assertEquals(points.get(i-1) && points.get(i), false);
        }
    }
}
