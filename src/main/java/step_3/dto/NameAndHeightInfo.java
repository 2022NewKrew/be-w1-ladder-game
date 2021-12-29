package step_3.dto;

public class NameAndHeightInfo extends LadderInfo {
    private final int width;
    private final int height;
    private final String[] names;

    public NameAndHeightInfo(String[] names, int height) {
        this.width = names.length;
        this.height = height;
        this.names = names;
    }

    @Override
    public int getWidth() { return width; }

    @Override
    public int getHeight() { return height; }

    @Override
    public String[] getNames() { return names; }
}
