package step_5.dto;

public abstract class LadderInfo {
    private int width;
    private int height;

    public abstract int getWidth();
    public abstract int getHeight();
    public abstract String[] getNames();
    public abstract String[] getResults();
}
