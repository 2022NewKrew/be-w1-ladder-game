package ladder;

import ladder.dto.InfoDto;
import ladder.view.InputView;
import ladder.view.OutputView;

public class Application {

    public static void main(String[] args) {
        final String[] players = InputView.inputPlayers();
        final String[] rewards = InputView.inputReward();
        final int ladderHeight = InputView.inputLadderHeight();

        final LadderController ladderController = new LadderController(players, rewards, ladderHeight);
        final InfoDto infoDto = ladderController.info();
        OutputView.printLadderInfo(infoDto);
    }
}
