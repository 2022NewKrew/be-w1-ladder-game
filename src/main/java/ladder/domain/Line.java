package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import ladder.utils.RandomUtils;

public class Line {

    private final List<Boolean> points;

    public Line(List<Boolean> points) {
        validate(points);
        this.points = new ArrayList<>(points);
    }

    public static Line valueOf(int countOfPerson) {
        validate(countOfPerson);
        final List<Boolean> points = new ArrayList<>();
        boolean prev = false;
        for (int i = 0; i < countOfPerson - 1; i++) {
            prev = nextRandomBoolean(prev);
            points.add(prev);
        }
        points.add(false);
        return new Line(points);
    }

    private static boolean nextRandomBoolean(boolean prev) {
        if (!prev) {
            return RandomUtils.nextBoolean();
        }
        return false;
    }

    private static void validate(int countOfPerson) {
        if (countOfPerson <= 0) {
            throw new IllegalArgumentException(Players.COUNT_OF_PEOPLE_NOT_ZERO);
        }
    }

    private void validate(List<Boolean> points) {
        validate(points.size());
        validatePoints(points);
    }

    private void validatePoints(List<Boolean> points) {
        boolean prevPoint = false;
        for (boolean point : points) {
            if (prevPoint && point) {
                throw new IllegalArgumentException("사다리 라인은 겹칠수 없음!!");
            }
            prevPoint = point;
        }
    }

    public List<Boolean> getPoints() {
        return points;
    }

    public int movedPoint(int startPoint) {
        if (Boolean.TRUE.equals(points.get(startPoint))) {
            return startPoint + 1;
        }
        if (startPoint - 1 >= 0 && Boolean.TRUE.equals(points.get(startPoint - 1))) {
            return startPoint - 1;
        }
        return startPoint;
    }
}
