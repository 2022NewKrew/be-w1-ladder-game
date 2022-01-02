package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {

    private static final String VERTICAL_BAR = "|";
    private static final String HORIZONTAL_BAR = "-";
    private static final String EMPTY_BAR = " ";
    private final static int FIRST_INDEX = 1;
    private static final String BLANK = "    ";
    private static final int LADDER_WIDTH = 5;

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

    private boolean setConnection(int index) {
        if (isVertical(index)) {
            return true;
        }
        return setFirstConnection(index) || setAfterFirstConnection(index);
    }

    private boolean setFirstConnection(int index) {
        return index == FIRST_INDEX && possibilityOneThird();
    }

    private boolean setAfterFirstConnection(int index) {
        return index != FIRST_INDEX && !isLeftConnected(index) && possibilityOneHalf();
    }

    private boolean isLeftConnected(int index) {
        return pointList.get(index - 2);
    }

    private boolean possibilityOneThird() {
        return random.nextInt(3) == 0;
    }

    private boolean possibilityOneHalf() {
        return random.nextBoolean();
    }

    public boolean isConnected(int index) {
        return pointList.get(index);
    }

    public boolean isVertical(int index) {
        return index % 2 == 0;
    }

    public StringBuilder pointListToString() {
        StringBuilder sb = new StringBuilder();
        sb.append(BLANK);
        for (int i = 0; i < lineSize; i++) {
            sb.append(pointToString(i));
        }
        return sb;
    }

    private String pointToString(int index) {
        if (isVertical(index)) return VERTICAL_BAR;
        if (isConnected(index)) {
            return HORIZONTAL_BAR.repeat(LADDER_WIDTH);
        }
        return EMPTY_BAR.repeat(LADDER_WIDTH);
    }

    public Move goToNextPoint(int index) {
        if (index != 0 && pointList.get(index - 1)) {
            return Move.LEFT;
        }
        if (index != pointList.size() - 1 && pointList.get(index + 1)) {
            return Move.RIGHT;
        }
        return Move.DOWN;
    }
}