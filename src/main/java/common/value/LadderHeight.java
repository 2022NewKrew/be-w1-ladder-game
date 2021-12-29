package common.value;

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
            throw new IllegalArgumentException("사다리 높이는 양수를 입력해주세요~");
        }
    }
}
