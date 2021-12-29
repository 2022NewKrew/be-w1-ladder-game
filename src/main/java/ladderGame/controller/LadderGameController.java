package ladderGame.controller;

import ladderGame.model.Ladder;
import ladderGame.model.Player;

import java.util.ArrayList;
import java.util.List;

public class LadderGameController {
    private static final String ERROR_INVALID_PLAYER_COUNT = "플레이어의 수는 한 명 이상이어야 합니다.";
    private static final String ERROR_INVALID_LADDER_HEIGHT = "사다리의 높이는 0보다 큰 숫자를 입력해야합니다.";
    private static final String ERROR_EMPTY_PLAYER_NAME = "플레이어의 이름은 한 글자 이상 입력해야합니다.";
    private static final String ERROR_MAX_LEN_PLAYER_NAME = "플레이어의 이름은 최대 5글자까지 입력해야합니다.";

    private final Player player;
    private final Ladder ladder;

    public LadderGameController(int ladderHeight, String playerNameString) {
        final List<String> playerNameList = getPlayerNameList(playerNameString);
        final int playerCount = playerNameList.size();

        validateLadder(playerCount, ladderHeight);

        final int ladderWidth = playerCount - 1;
        this.ladder = Ladder.makeLadder(ladderHeight, ladderWidth);
        this.player = new Player(playerCount, playerNameList);
    }

    private List<String> getPlayerNameList(String playerNameString) {
        final String[] playerNameArr = playerNameString.split(",");
        List<String> playerNameList = new ArrayList<>();

        for (String playerName : playerNameArr) {
            validatePlayerName(playerName);
            playerNameList.add(playerName);
        }

        return playerNameList;
    }

    private void validateLadder(int playerCount, int ladderHeight) {
        if (playerCount <= 0) {
            throw new IllegalArgumentException(ERROR_INVALID_PLAYER_COUNT);
        }

        if (ladderHeight <= 0) {
            throw new IllegalArgumentException(ERROR_INVALID_LADDER_HEIGHT);
        }
    }

    private void validatePlayerName(String playerName) {
        if (playerName.isEmpty()) {
            throw new IllegalArgumentException(ERROR_EMPTY_PLAYER_NAME);
        }

        if (playerName.length() > 5) {
            throw new IllegalArgumentException(ERROR_MAX_LEN_PLAYER_NAME);
        }
    }

    public Ladder getLadder() {
        return ladder;
    }

    public Player getPlayer() {
        return player;
    }
}
