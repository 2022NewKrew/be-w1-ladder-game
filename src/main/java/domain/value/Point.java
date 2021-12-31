package domain.value;

import common.value.DirectionType;

public class Point {

    private DirectionType direction;

    public Point() {
        this.direction = DirectionType.DOWN;
    }

    public DirectionType getDirection() {
        return direction;
    }

    public void setDirection(DirectionType direction) {
        this.direction = direction;
    }

    public int getNextVerticalLine(int verticalLineIndex) {
        switch (this.getDirection()) {
            case DOWN:
                return verticalLineIndex;
            case LEFT:
                return verticalLineIndex - 1;
            case RIGHT:
                return verticalLineIndex + 1;
        }
        return -1;
    }

    public boolean isConnectableTo(Point targetPoint) {
        if(this.direction == DirectionType.LEFT || this.direction == DirectionType.RIGHT ||
                targetPoint.getDirection() == DirectionType.RIGHT) {
            return false;
        }
        return true;
    }

}
