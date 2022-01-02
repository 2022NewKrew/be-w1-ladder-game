package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static ladder.domain.LadderConstant.*;

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

    public boolean isLeftConnected(int index) {
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
            return HORIZONTAL_BAR;
        }
        return EMPTY_BAR;
    }

    public Move goToNextPoint(int index) {
        if (!isFirstIndex(index) && isGoLeft(index)) {
            return Move.LEFT;
        }
        if (!isLastIndex(index) && isGoRight(index)) {
            return Move.RIGHT;
        }
        return Move.DOWN;
    }

    private boolean isGoLeft(int index) {
        return pointList.get(index - 1);
    }

    private boolean isGoRight(int index) {
        return pointList.get(index + 1);
    }

    private boolean isFirstIndex(int index) {
        return index != 0;
    }

    private boolean isLastIndex(int index) {
        return index != pointList.size() - 1;
    }
}