package domain.value;

import common.value.DirectionType;

import java.util.ArrayList;
import java.util.List;

public class VerticalLine {

    private final List<Point> points = new ArrayList<>();

    public VerticalLine(int height) {
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

    public boolean isConnectableTo(VerticalLine target, int height) {
        Point point = points.get(height);
        Point targetPoint = target.getPoint(height);
        if(point.getDirection() == DirectionType.LEFT ||
                point.getDirection() == DirectionType.RIGHT ||
                targetPoint.getDirection() == DirectionType.RIGHT) {
            return false;
        }
        return true;
    }
}
