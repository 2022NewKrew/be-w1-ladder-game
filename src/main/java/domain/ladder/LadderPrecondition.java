package domain.ladder;

public class LadderPrecondition {
    public static void checkFrameLength(int frameLength, int MIN_LENGTH) {
        if (frameLength < MIN_LENGTH) {
            throw new IllegalArgumentException("참여하는 사람의 수는 양의 정수여야 합니다.");
        }
    }

    public static void checkLadderHeight(int height, int MIN_LENGTH) {
        if (height < MIN_LENGTH) {
            throw new IllegalArgumentException("사다리의 높이는 양의 정수여야 합니다.");
        }
    }
}
