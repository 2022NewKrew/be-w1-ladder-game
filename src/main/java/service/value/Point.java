package service.value;

public class Point {

    private static final int LEFT = 0;
    private static final int DOWN = 1;
    private static final int RIGHT = 2;

    private int direction;

    public Point() {
        this.direction = DOWN;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

}
