package domain.data;

import common.value.Players;
import domain.value.Ladder;

public class GameResult {

    private final Players players;

    private final Ladder ladder;

    public GameResult(Players players, Ladder ladder) {
        this.players = players;
        this.ladder = ladder;
    }

    public Players getPlayers() {
        return players;
    }

    public Ladder getLadders() {
        return ladder;
    }
}
