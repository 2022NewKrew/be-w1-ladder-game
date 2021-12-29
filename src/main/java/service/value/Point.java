package service.value;

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

}
