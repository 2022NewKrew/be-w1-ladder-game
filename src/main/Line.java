package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {
    final static boolean BRIDGE_ON_THE_RIGHT = true;
    final static boolean NO_BRIDGE_ON_THE_RIGHT = false;

    private List<Boolean> points = new ArrayList<>();

    public Line(int peopleCount) {
        makeLine(peopleCount);
    }

    public void makeLine(int count) {
        Random random = new Random();
        boolean previousPoint = random.nextBoolean();
        this.points.add(previousPoint);

        for (int i = 1; i < count - 1; i++) {
            if (previousPoint == NO_BRIDGE_ON_THE_RIGHT && random.nextBoolean()) {
                this.points.add(BRIDGE_ON_THE_RIGHT);
                previousPoint = BRIDGE_ON_THE_RIGHT;
                continue;
            }
            this.points.add(NO_BRIDGE_ON_THE_RIGHT);
        }
        this.points.add(NO_BRIDGE_ON_THE_RIGHT);
    }

    public List<Boolean> getPoints() {
        return points;
    }
}
