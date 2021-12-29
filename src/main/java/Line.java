import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {

    private final int LINE_SIZE;
    private final List<Boolean> POINT_LIST;
    private final Random RANDOM = new Random();

    public Line(int playerNumber) {
        LINE_SIZE = playerNumber * 2 - 1;
        POINT_LIST = new ArrayList<>(LINE_SIZE);
        setPoint();
    }

    public int getLINE_SIZE() {
        return LINE_SIZE;
    }

    private void setPoint() {
        for (int i = 0; i < LINE_SIZE; i++) {
            POINT_LIST.add(setConnection(i));
        }
    }

    public boolean setConnection(int index) {
        return isVertical(index) || RANDOM.nextBoolean();
    }

    public boolean isConnected(int index) {
        return POINT_LIST.get(index);
    }

    public boolean isVertical(int index) {
        return index % 2 == 0;
    }
}