package repository;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LineTest {

    @Test
    public void lineTest(){
        Line line = new Line();
        line.addPoint(new Point(0, true));
        line.addPoint(new Point(1, false));
        line.addPoint(new Point(2, false));
        line.addPoint(new Point(3, true));
        line.addPoint(new Point(4, false));

        assertTrue(line.getPointValid(0));
        assertFalse(line.getPointValid(1));
        assertFalse(line.getPointValid(2));
        assertTrue(line.getPointValid(3));
        assertFalse(line.getPointValid(4));

    }

}