package ladderGame.domain;

import java.util.ArrayList;
import java.util.List;

public class Players {
    private static final int MIN_PLAYER_COUNT = 1;
    private static final String ERROR_INVALID_PLAYER_COUNT = "플레이어의 수는 한 명 이상이어야 합니다.";
    private static final String SPLIT_DELIMITER = ",";

    private final int playerCount;
    private final List<PlayerInfo> playerInfos;

    public Players(List<PlayerInfo> players) {
        this.playerInfos = new ArrayList<>(players);
        this.playerCount = players.size();
    }

    public static Players makePlayers(String playersName) {
        List<PlayerInfo> playerInfos = new ArrayList<>();

        final String[] names = playersName.split(SPLIT_DELIMITER);
        for (String name : names) {
            playerInfos.add(new PlayerInfo(name.trim()));
        }

        validatePlayerCount(playerInfos.size());
        return new Players(playerInfos);
    }

    private static void validatePlayerCount(int playerCount) {
        if (playerCount < MIN_PLAYER_COUNT) {
            throw new IllegalArgumentException(ERROR_INVALID_PLAYER_COUNT);
        }
    }

    public int getPlayerCount() {
        return playerCount;
    }

    public List<PlayerInfo> getPlayerInfos() {
        return playerInfos;
    }
}
