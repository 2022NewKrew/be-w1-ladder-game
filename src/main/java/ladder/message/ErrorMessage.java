package ladder.message;

public enum ErrorMessage {
    EMPTY_NAMES("주어진 이름이 없습니다"),
    EMPTY_NAME("사람 이름이 비었습니다"),
    EXCEED_MAX_NAME("이름 길이는 5자 이하여야 합니다"),
    NEGATIVE_HEIGHT("사다리 높이는 양의 정수여야 합니다");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
