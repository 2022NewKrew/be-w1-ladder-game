package ladderGame.domain;

public class PlayerInfo {
    private static final int MAX_PLAYER_NAME_LENGTH = 5;
    private static final String ERROR_EMPTY_PLAYER_NAME = "플레이어의 이름은 한 글자 이상 입력해야합니다.";
    private static final String ERROR_MAX_LEN_PLAYER_NAME = "플레이어의 이름은 최대 5글자까지 입력해야합니다.";

    private final String name;

    public PlayerInfo(String name) {
        validatePlayerName(name);
        this.name = name;
    }

    private void validatePlayerName(String playerName) {
        if (playerName.isEmpty()) {
            throw new IllegalArgumentException(ERROR_EMPTY_PLAYER_NAME);
        }

        if (playerName.length() > MAX_PLAYER_NAME_LENGTH) {
            throw new IllegalArgumentException(ERROR_MAX_LEN_PLAYER_NAME);
        }
    }

    public String getName() {
        return name;
    }
}
