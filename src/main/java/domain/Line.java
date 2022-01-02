package main.java.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {
    private static final boolean BRIDGE = true;
    private static final boolean NO_BRIDGE = false;
    private static final String LADDER_PILLAR = "|";
    private static final String LADDER_BRIDGE = "-----";
    private static final String LADDER_EMPTY = "     ";
    private static final int MIN_COUNT = 2;

    private List<Point> points;
    private Random random = new Random();

    private Line(int peopleCount) {
        this.points = new ArrayList<>();
        makeLine(peopleCount);
    }

    public static Line create(int peopleCount) {
        if (peopleCount < MIN_COUNT) {
            throw new IllegalArgumentException();
        }
        return new Line(peopleCount);
    }

    private void makeLine(int peopleCount) {
        boolean previousPoint = this.random.nextBoolean();
        this.points.add(Point.create(NO_BRIDGE, previousPoint));

        boolean tempPoint;
        for (int i = 1; i < peopleCount - 1; i++) {
            tempPoint = previousPoint;
            this.points.add(Point.create(tempPoint, previousPoint = isThereBridge(previousPoint)));
        }

        this.points.add(Point.create(previousPoint, NO_BRIDGE));
    }

    private boolean isThereBridge(boolean previousPoint) {
        if (previousPoint == NO_BRIDGE && this.random.nextBoolean()) {
            return BRIDGE;
        }
        return NO_BRIDGE;
    }

    public Point getPoint(int order) {
        return this.points.get(order);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.points.size() - 1; i++) {
            if (points.get(i).isInRightBridge() == BRIDGE) {
                sb.append(LADDER_PILLAR);
                sb.append(LADDER_BRIDGE);
                continue;
            }
            sb.append(LADDER_PILLAR);
            sb.append(LADDER_EMPTY);
        }

        sb.append(LADDER_PILLAR);
        return sb.toString();
    }
}
