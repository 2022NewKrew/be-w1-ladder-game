import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Line {
    private static final Random random = new Random();

    private final List<Point> points = new ArrayList<>();

    public Line(int numOfPeople) {
        int pointCnt = numOfPeople - 1;
        createLine(pointCnt);
    }

    private void createLine(int pointCnt) {
        for (int i = 0; i < pointCnt; i++) {
            points.add(new Point(random.nextBoolean()));
        }
    }

    public List<Point> getPoints() {
        return points;
    }
}
