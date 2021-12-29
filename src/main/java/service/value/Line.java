package service.value;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private final List<Point> points;

    public Line(int height) {
        this.points = new ArrayList<>();
        for(int index = 0; index < height; index++) {
            points.add(new Point());
        }
    }

    public Point getPoint(int index) {
        return points.get(index);
    }

    public int getHeight() {
        return points.size();
    }
}
