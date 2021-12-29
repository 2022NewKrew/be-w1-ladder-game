import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {

    public static final String LINE_VERTICAL = "|";
    public static final String LINE_HORIZONTAL_TRUE = "-";
    public static final String LINE_HORIZONTAL_FALSE = " ";

    private final int LINE_SIZE;
    private final List<Boolean> POINT_LIST;
    private final Random RANDOM = new Random();

    public Line(int playerNumber) {
        LINE_SIZE = playerNumber * 2 - 1;
        POINT_LIST = new ArrayList<>(LINE_SIZE);
        setPoint();
    }

    private void setPoint() {
        for (int i = 0; i < LINE_SIZE; i++) {
            POINT_LIST.add(isConnected(i));
        }
    }

    private boolean isConnected(int index) {
        if (index % 2 == 0||RANDOM.nextBoolean()) {
            return true;
        } return false;
    }

    private String pointToString(int index) {
        if (index % 2 == 0) return LINE_VERTICAL;
        if (POINT_LIST.get(index)) {
            return LINE_HORIZONTAL_TRUE;
        } return LINE_HORIZONTAL_FALSE;
    }

    public void printLine() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < LINE_SIZE; i++) {
            sb.append(pointToString(i));
        }
        System.out.println(sb);
    }
}
