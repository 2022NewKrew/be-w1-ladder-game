package view.input.config;

public class LadderConfig {
    // 불변
    private final int peopleCount;
    private final int height;

    public LadderConfig(int peopleCount, int height) {
        this.peopleCount = peopleCount;
        this.height = height;
    }

    public int getPeopleCount() {
        return peopleCount;
    }

    public int getHeight() {
        return height;
    }
}
