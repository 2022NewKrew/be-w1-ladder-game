package domain.ladder;

public class LadderPrecondition {
    public static void checkFrameLength(int frameLength, int minLength) {
        if (frameLength < minLength) {
            throw new IllegalArgumentException("참여하는 사람의 수는 양의 정수여야 합니다.");
        }
    }

    public static void checkLadderHeight(int height, int minLength) {
        if (height < minLength) {
            throw new IllegalArgumentException("사다리의 높이는 양의 정수여야 합니다.");
        }
    }
}
