package ladder.domain;

import ladder.view.PointGenerator;
import ladder.view.StringLineGenerator;

import java.util.ArrayList;
import java.util.List;

public class Line {
    // 상수
    private static final String COLUMN = "|";
    private static final String CONNECTED = "-";
    private static final String NOT_CONNECTED = " ";

    // 인스턴스 변수
    private final List<Boolean> points;
    private final int participantLimit;
    private final StringLineGenerator stringLineGenerator;

    public Line (int peopleCount, int participantLimit,
                 StringLineGenerator stringLineGenerator,
                 PointGenerator pointGenerator) {
        points = new ArrayList<>();
        this.participantLimit = participantLimit;
        this.stringLineGenerator = stringLineGenerator;

        for (int i=0; i < peopleCount - 1; i++) {
            points.add(pointGenerator.addPoint(points));
        }
    }

    @Override
    public String toString() {
        return stringLineGenerator.createRowString(
                points, COLUMN, CONNECTED, NOT_CONNECTED, participantLimit);
    }
}
