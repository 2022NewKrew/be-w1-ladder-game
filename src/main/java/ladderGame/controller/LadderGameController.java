package ladderGame.controller;

import ladderGame.domain.Ladder;
import ladderGame.domain.Players;
import ladderGame.view.InputView;
import ladderGame.view.OutputView;

import java.io.IOException;

public class LadderGameController {
    private Players players;
    private Ladder ladder;

    public LadderGameController() { }

    public void run() throws IOException {
        final String playersName = InputView.inputPlayersName();
        final int ladderHeight = InputView.inputLadderHeight();

        this.players = Players.makePlayers(playersName);

        final int ladderWidth = this.players.getPlayerCount() - 1;
        this.ladder = Ladder.makeLadder(ladderHeight, ladderWidth);

        OutputView.drawLadderGame(players, ladder);
    }
}
