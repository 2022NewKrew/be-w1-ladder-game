package main.java.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {
    public final static boolean BRIDGE_ON_THE_RIGHT = true;
    public final static boolean NO_BRIDGE_ON_THE_RIGHT = false;
    final static String LADDER_PILLAR = "|";
    final static String LADDER_BRIDGE = "-----";
    final static String LADDER_EMPTY = "     ";

    private List<Boolean> points = new ArrayList<>();

    public Line(int peopleCount) {
        makeLine(peopleCount);
    }

    private void makeLine(int count) {
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.points.size() - 1; i++) {
            if (points.get(i) == Line.BRIDGE_ON_THE_RIGHT) {
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
