package domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class LadderLine {

    private List<Boolean> points = new ArrayList<Boolean>();

    public LadderLine(int countOfPerson) {
        Random random = new Random();
        points.add(random.nextInt(3) == 0);
        for (int i = 1 ; i < countOfPerson - 1 ; i++) {
            points.add(random.nextBoolean() && !points.get(i - 1));
        }
    }

    public List<Boolean> getPoints() {
        return points;
    }
}
