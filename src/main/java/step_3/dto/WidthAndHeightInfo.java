package step_3.dto;

public class WidthAndHeightInfo extends LadderInfo {
    private final int width;
    private final int height;

    public WidthAndHeightInfo(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public String[] getNames() {
        return null;
    }
}
