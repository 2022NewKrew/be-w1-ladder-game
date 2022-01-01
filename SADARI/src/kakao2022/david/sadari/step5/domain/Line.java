package kakao2022.david.sadari.step5.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {
    private static final Random random = new Random();
    private final List<Boolean> points = new ArrayList<>();
    protected boolean isPrevLine = false;

    public Line() {
    }

    public Line(int countOfPerson) {
        for (int i = 0; i < countOfPerson - 1; i++) {
            points.add(addPoint(random.nextBoolean()));
        }
    }

    protected boolean addPoint(boolean draw) {
        if (!isPrevLine && draw) {
            isPrevLine = true;
            return true;
        }
        isPrevLine = false;
        return false;
    }

    public boolean isLine(int position) {
        if (position == -1 || position == points.size()) {
            return false;
        }
        return points.get(position);
    }

    public StringBuilder getLineInfo() {
        StringBuilder lineInfo = new StringBuilder("  |");
        for (boolean point : points) {
            lineInfo.append(getLadderLine(point));
            lineInfo.append("|");
        }
        return lineInfo;
    }


    private String getLadderLine(boolean point) {
        return point ? "-----" : "     ";
    }
}
