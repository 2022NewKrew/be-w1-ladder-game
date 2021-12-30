package ladderGame;

import ladderGame.controller.LadderGameController;
import ladderGame.domain.Ladder;
import ladderGame.domain.Player;
import ladderGame.view.InputView;
import ladderGame.view.OutputView;

import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException {
        final String playerNameString = InputView.inputPlayersName();
        final int ladderHeight = InputView.inputLadderHeight();

        final LadderGameController ladderGameController =
                new LadderGameController(ladderHeight, playerNameString);

        final Ladder ladder = ladderGameController.getLadder();
        final Player player = ladderGameController.getPlayer();

        OutputView.drawLadderGame(player, ladder);
    }
}
