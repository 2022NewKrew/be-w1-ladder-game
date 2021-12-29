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
        for (int i = 0; i < LINE_SIZE; i++) {
            POINT_LIST.add(setConnection(i));
        }
    }

    public int getLINE_SIZE() {
        return LINE_SIZE;
    }

    public boolean setConnection(int index) {
        if (isVertical(index)) {
            return true;
        }
        return setFirstConnection(index) || setAfterFirstConnection(index);
    }

    private boolean setFirstConnection(int index) {
        return index == 1 && RANDOM.nextInt(3) == 0;
    }

    private boolean setAfterFirstConnection(int index) {
        return index != 1 && !POINT_LIST.get(index - 2) && RANDOM.nextBoolean();
    }

    public boolean isConnected(int index) {
        return POINT_LIST.get(index);
    }

    public boolean isVertical(int index) {
        return index % 2 == 0;
    }
}