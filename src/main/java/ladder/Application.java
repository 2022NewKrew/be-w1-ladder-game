package ladder;

import ladder.dto.ResultDto;
import ladder.view.InputView;
import ladder.view.OutputView;

public class Application {

    public static void main(String[] args) {
        final String[] players = InputView.inputPlayers();
        final int ladderHeight = InputView.inputLadderHeight();

        final LadderController ladderController = new LadderController(players, ladderHeight);
        final ResultDto resultDto = ladderController.result();
        OutputView.printResult(resultDto);
    }
}
