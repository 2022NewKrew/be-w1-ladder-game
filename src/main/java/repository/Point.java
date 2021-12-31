package repository;

public class Point {
    private final int point;
    private final boolean connected;
    public Point(int point, boolean connected){
        this.point = point;
        this.connected = connected;
    }

    public int getPoint() { return point; }
    public boolean getConnected() { return connected; }
}
