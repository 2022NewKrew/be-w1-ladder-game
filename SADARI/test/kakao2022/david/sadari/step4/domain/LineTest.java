package kakao2022.david.sadari.step4.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LineTest {

    @Test
    void addPointFF() {
        Line line = new Line();
        line.isPrevLine = false;
        assertFalse(line.addPoint(false));
    }

    @Test
    void addPointFT() {
        Line line = new Line();
        line.isPrevLine = false;
        assertTrue(line.addPoint(true));
    }

    @Test
    void addPointTF() {
        Line line = new Line();
        line.isPrevLine = true;
        assertFalse(line.addPoint(false));
    }

    @Test
    void addPointTT() {
        Line line = new Line();
        line.isPrevLine = true;
        assertFalse(line.addPoint(true));
    }
}