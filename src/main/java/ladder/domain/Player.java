package ladder.domain;

import ladder.exception.NameLengthException;

//플레이어
public class Player {
    private PlayerName playerName;

    public Player(String name) {
        playerName = new PlayerName(name);
    }

    public String getName() {
        return playerName.getName();
    }

    public void checkPlayerName() {
        try {
            playerName.checkNameLength();
        } catch (NameLengthException nameLengthException) {
            throw nameLengthException;
        }
    }
}
