public class Point {
    private boolean step;

    public Point(boolean step) {
        this.step = step;
    }

    public boolean isStep() {
        return step;
    }

    public void removeStep() {
        this.step = false;
    }
}
