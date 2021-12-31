package step_5.dto;

public class NameAndResultInfo extends LadderInfo {
    private final int width;
    private final int height;
    private final String[] names;
    private final String[] results;

    public NameAndResultInfo(String[] names, String[] results, int height) {
        this.width = names.length;
        this.height = height;
        this.names = names;
        this.results = results;
    }

    @Override
    public int getWidth() { return width; }

    @Override
    public int getHeight() { return height; }

    @Override
    public String[] getNames() { return names; }

    @Override
    public String[] getResults() { return results; }
}
