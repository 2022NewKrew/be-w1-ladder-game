package ladder.message;

public enum GameMessage {
    LADDER_HEIGHT_INPUT("최대 사다리 높이는 얼마인가요"),
    NAME_INPUT("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");

    private final String message;

    GameMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
