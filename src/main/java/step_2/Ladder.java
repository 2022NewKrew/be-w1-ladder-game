package step_2;

public class Ladder {
    private final int width, height;
    private StringBuilder shape;

    public Ladder(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public void setShape(StringBuilder shape) {
        this.shape = shape;
    }

    public StringBuilder getShape() {
        return shape;
    }
}
