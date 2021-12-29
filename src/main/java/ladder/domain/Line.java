package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import ladder.utils.RandomUtils;

public class Line {

    private final List<Boolean> points;

    public Line(List<Boolean> points) {
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
            throw new IllegalArgumentException("인원은 0명 이하일 수 없습니다.");
        }
    }

    public List<Boolean> getPoints() {
        return points;
    }
}
