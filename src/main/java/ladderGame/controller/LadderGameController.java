package ladderGame.controller;

import ladderGame.domain.Ladder;
import ladderGame.domain.Player;

import java.util.ArrayList;
import java.util.List;

public class LadderGameController {
    private final Player player;
    private final Ladder ladder;

    public LadderGameController(int ladderHeight, String playerNameString) {
        this.player = new Player(playerNameString);

        final int ladderWidth = player.getPlayerCount() - 1;
        this.ladder = Ladder.makeLadder(ladderHeight, ladderWidth);
    }

    public Ladder getLadder() {
        return ladder;
    }

    public Player getPlayer() {
        return player;
    }
}
