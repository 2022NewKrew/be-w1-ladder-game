package ladder.message;

public enum GameMessage {
    LADDER_HEIGHT_INPUT("최대 사다리 높이는 얼마인가요"),
    NAME_INPUT("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)"),
    RESULT_INPUT("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)"),
    GAME_RESULT("사다리 결과"),
    PLAYER_WHO_WANTS_TO_SEE_RESULT("결과를 보고 싶은 사람은?"),
    RESULT_OF_PLAYER("실행 결과"),
    END_GAME("게임을 종료합니다.");

    private final String message;

    GameMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
