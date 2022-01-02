package main.java.domain;

public class Point {

    private boolean inLeftBridge;
    private boolean inRightBridge;

    public Point(boolean inLeftBridge, boolean inRightBridge) {
        this.inLeftBridge = inLeftBridge;
        this.inRightBridge = inRightBridge;
    }

    public static Point create(boolean inLeftBridge, boolean inRightBridge) {
        return new Point(inLeftBridge, inRightBridge);
    }

    public boolean isInLeftBridge() {
        return inLeftBridge;
    }

    public boolean isInRightBridge() {
        return inRightBridge;
    }
}
