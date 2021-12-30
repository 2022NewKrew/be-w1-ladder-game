package domain.ladder;

public class LadderPrecondition {
<<<<<<< HEAD
    public static void checkFrameLength(int frameLength, int minLength) {
        if (frameLength < minLength) {
=======
    public static void checkFrameLength(int frameLength, int MIN_LENGTH) {
        if (frameLength < MIN_LENGTH) {
>>>>>>> 05c0cd8 (리뷰받은 내용 중 gradle관련 수정)
            throw new IllegalArgumentException("참여하는 사람의 수는 양의 정수여야 합니다.");
        }
    }

<<<<<<< HEAD
    public static void checkLadderHeight(int height, int minLength) {
        if (height < minLength) {
=======
    public static void checkLadderHeight(int height, int MIN_LENGTH) {
        if (height < MIN_LENGTH) {
>>>>>>> 05c0cd8 (리뷰받은 내용 중 gradle관련 수정)
            throw new IllegalArgumentException("사다리의 높이는 양의 정수여야 합니다.");
        }
    }
}
