package ladderGame.domain;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private static final String ERROR_EMPTY_PLAYER_NAME = "플레이어의 이름은 한 글자 이상 입력해야합니다.";
    private static final String ERROR_MAX_LEN_PLAYER_NAME = "플레이어의 이름은 최대 5글자까지 입력해야합니다.";
    private static final String ERROR_INVALID_PLAYER_COUNT = "플레이어의 수는 한 명 이상이어야 합니다.";

    private final int playerCount;
    private final List<String> playerNameList;

    public Player(String playerNameString) {
        final List<String> playerNameList = getPlayerNameList(playerNameString);

        this.playerCount = playerNameList.size();
        this.playerNameList = new ArrayList<>(playerNameList);
    }

    private List<String> getPlayerNameList(String playerNameString) {
        final String[] playerNameArr = playerNameString.split(",");
        List<String> playerNameList = new ArrayList<>();

        for (String playerName : playerNameArr) {
            validatePlayerName(playerName);
            playerNameList.add(playerName);
        }

        validatePlayerCount(playerNameList.size());
        return playerNameList;
    }

    private void validatePlayerName(String playerName) {
        if (playerName.isEmpty()) {
            throw new IllegalArgumentException(ERROR_EMPTY_PLAYER_NAME);
        }

        if (playerName.length() > 5) {
            throw new IllegalArgumentException(ERROR_MAX_LEN_PLAYER_NAME);
        }
    }

    private void validatePlayerCount(int playerCount) {
        if (playerCount <= 0) {
            throw new IllegalArgumentException(ERROR_INVALID_PLAYER_COUNT);
        }
    }

    public List<String> getPlayerNameList() {
        return playerNameList;
    }
    public int getPlayerCount() { return playerCount; }
}
