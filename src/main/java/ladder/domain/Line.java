package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import ladder.utils.RandomUtils;

public class Line {

    private final List<Boolean> points;

    public Line(List<Boolean> points) {
        // todo - size 0 이하면 에러처리
        this.points = new ArrayList<>(points);
    }

    public static Line valueOf(int person) {
        final List<Boolean> points = new ArrayList<>();
        for (int i = 0; i < person - 1; i++) {
            points.add(RandomUtils.nextBoolean());
        }
        return new Line(points);
    }

    public List<Boolean> getPoints() {
        return points;
    }
}
