package input;

public class LadderConfig {
    // 불변
    private final int width;
    private final int height;

    public LadderConfig(int width, int height) {
        this.width = width;
        this.height = height;
        validateInput();
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    // 입력값을 검증 (음수 여부)
    private void validateInput() {
        if (this.width < 1) throw new IllegalArgumentException();
        if (this.height < 1) throw new IllegalArgumentException();
    }
}
