package ladder.domain;

import java.util.ArrayList;
import java.util.Random;

public class Line {
    private final ArrayList<Boolean> points = new ArrayList<>();

    public Line(int numOfPlayer, Random random) {
        boolean existLeft = false;

        for(int i=0; i<numOfPlayer-1; i++) {
            boolean point = !existLeft && random.nextBoolean();
            points.add(point);
            existLeft = point;
        }
    }

    public ArrayList<Boolean> getPoints() {
        return points;
    }
}