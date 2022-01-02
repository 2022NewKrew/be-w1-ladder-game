package test.java;

import main.java.domain.Line;
import main.java.domain.LineGenerator;
import main.java.domain.Point;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class LineTest {
    @Test
    public void Line_Point_수_Test(){
        LineGenerator lineGenerator = new LineGenerator();
        Line line = (Line) lineGenerator.generateLine(10);
        assertEquals(line.points().size(),10);
    }

    @Test
    public void Line_겹침_Test(){
        LineGenerator lineGenerator = new LineGenerator();
        Line line = (Line) lineGenerator.generateLine(10);
        List<Point> points = line.points();
        for(int i = 0; i < points.size() - 1; i++){
            assertNotEquals(2, points.get(i).move() + points.get(i+1).move());
        }
    }
}
