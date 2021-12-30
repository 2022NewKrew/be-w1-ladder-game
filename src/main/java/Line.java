import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {

    private final int lineSize;
    private final List<Boolean> pointList;
    private final static Random random = new Random();

    public Line(int playerNumber) {
        lineSize = playerNumber * 2 - 1;
        pointList = new ArrayList<>(lineSize);
        for (int i = 0; i < lineSize; i++) {
            pointList.add(setConnection(i));
        }
    }

    public int getLineSize() {
        return lineSize;
    }

    public boolean setConnection(int index) {
        if (isVertical(index)) {
            return true;
        }
        return setFirstConnection(index) || setAfterFirstConnection(index);
    }

    private boolean setFirstConnection(int index) {
        return index == 1 && random.nextInt(3) == 0;
    }

    private boolean setAfterFirstConnection(int index) {
        return index != 1 && !pointList.get(index - 2) && random.nextBoolean();
    }

    public boolean isConnected(int index) {
        return pointList.get(index);
    }

    public boolean isVertical(int index) {
        return index % 2 == 0;
    }
}