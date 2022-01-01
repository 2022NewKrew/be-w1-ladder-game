package domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class LadderLine {

    private List<Boolean> points = new ArrayList<Boolean>();
    private static final Random random = new Random();

    public LadderLine(int countOfPerson) {
        points.add(random.nextInt(3) == 0);
        for (int i = 1 ; i < countOfPerson - 1 ; i++) {
            points.add(addPoint(points.get(points.size() - 1)));
        }
    }

    private Boolean addPoint(Boolean lastPoint) {
        return random.nextBoolean() && !lastPoint;
    }

    public List<Boolean> getPoints() {
        return points;
    }
}
