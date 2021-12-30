package kakao2022.david.sadari.step4.domain;

import java.util.ArrayList;
import java.util.Random;

public class Line {
    private static final Random random = new Random();
    private final ArrayList<Boolean> points = new ArrayList<>();
    protected boolean isPrevLine = false;

    public Line() {
    }

    public Line(int countOfPerson) {
        for (int i = 0; i < countOfPerson - 1; i++) {
            points.add(addPoint(random.nextBoolean()));
        }
    }

    protected boolean addPoint(boolean draw) {
        return isPrevLine = (!isPrevLine && draw);
    }

    public ArrayList<Boolean> getPoints() {
        return points;
    }
}
