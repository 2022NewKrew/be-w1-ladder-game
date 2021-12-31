package ladder.domain;

import ladder.view.PointGenerator;

import java.util.ArrayList;
import java.util.List;

public class Line {
    // 인스턴스 변수
    private final List<Boolean> points;

    // 생성자
    public Line (int peopleCount,
                 PointGenerator pointGenerator) {
        points = new ArrayList<>();

        for (int i=0; i < peopleCount - 1; i++) {
            points.add(pointGenerator.appendPoint(points));
        }
    }

    // 메서드
    public Integer moveLine(Integer x) {
        if (x < points.size() && points.get(x)) {
            return x+1;
        }

        if (x > 0 && points.get(x-1)) {
            return x-1;
        }

        return x;
    }

    public List<Boolean> getPoints() {
        return this.points;
    }
}
