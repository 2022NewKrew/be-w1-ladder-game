package repository;

public class Point {
    private final int point;
    private final boolean valid;
    public Point(int point, boolean valid){
        this.point = point;
        this.valid = valid;
    }

    public int getPoint() { return point; }
    public boolean getValid() { return valid; }
}
