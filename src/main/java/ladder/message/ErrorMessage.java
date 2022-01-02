package ladder.message;

public enum ErrorMessage {
    EMPTY_NAMES("주어진 이름이 없습니다"),
    EMPTY_NAME("사람 이름이 비었습니다"),
    EXCEED_MAX_NAME("이름 길이는 5자 이하여야 합니다"),
    NEGATIVE_HEIGHT("사다리 높이는 양의 정수여야 합니다"),
    EMPTY_LADDER_RESULTS("주어진 결과가 없습니다"),
    EMPTY_LADDER_RESULT("결과가 비었습니다"),
    EXCEED_MAX_LADDER_RESULT("결과 길이는 5자 이하여야 합니다"),
    NAME_AND_RESULT_SIZE_ARE_DIFFERENT("이름 개수와 결과 개수가 다릅니다");


    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
