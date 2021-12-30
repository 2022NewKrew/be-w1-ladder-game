import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {
    // 상수
    private static final String COLUMN = "|";
    private static final String CONNECTED = "-----";
    private static final String NOT_CONNECTED = "     ";
    private static final String PADDING = "  ";

    // 인스턴스 변수
    private final List<Boolean> points;
    private final Random random;

    public Line (int peopleCount) {
        points = new ArrayList<>();
        random = new Random();

        for (int i=0; i < peopleCount - 1; i++) {
            points.add(createPoint(i));
        }
    }

    private Boolean createPoint(int x) {
        if (x == 0) {
            return random.nextBoolean();
        }

        return points.get(x-1) ? Boolean.FALSE : random.nextBoolean();
    }

    private List<String> createRowString() {
        List<String> result = new ArrayList<>();
        result.add(PADDING);
        for (Boolean isConnected : points) {
            result.add(COLUMN);
            result.add(isConnected ? CONNECTED : NOT_CONNECTED);
        }
        result.add(COLUMN);

        return result;
    }

    @Override
    public String toString() {
        return String.join("", createRowString());
    }
}
