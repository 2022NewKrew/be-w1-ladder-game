package domain;

import java.util.*;

public class Line {
    private static final Random random = new Random();

    private final List<Point> points = new ArrayList<>();

    public Line(int numOfPeople) {
        int pointCnt = numOfPeople - 1;
        createLine(pointCnt);
    }

    private void createLine(int pointCnt) {
        boolean isPrevStep = false;
        for (int i = 0; i < pointCnt; i++) {
            Point point = createPoint(isPrevStep);
            points.add(point);
            isPrevStep = point.isStep();
        }
    }

    private Point createPoint(boolean isPrevStep){
        if(isPrevStep) return new Point(false);

        return new Point(random.nextBoolean());
    }

    public List<Point> getPoints() {
        return Collections.unmodifiableList(points);
    }
}
