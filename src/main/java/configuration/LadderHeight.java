package configuration;

public class LadderHeight {

    private final int maxHeight;

    public LadderHeight(int maxHeight) {
        validateMaxHeight(maxHeight);
        this.maxHeight = maxHeight;
    }

    public int getValue() {
        return maxHeight;
    }

    private void validateMaxHeight(int maxHeight) {
        if(maxHeight < 0) {
            throw new IllegalArgumentException("양수를 입력하세요.");
        }
    }
}
