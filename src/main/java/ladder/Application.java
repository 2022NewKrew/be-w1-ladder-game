package ladder;

import ladder.controller.LadderController;
import ladder.view.InputView;
import ladder.view.OutputView;

public class Application {

    public static void main(String[] args) {
        int personCount = InputView.inputPerson();
        int ladderCount = InputView.inputLadder();

        LadderController ladderController = new LadderController(ladderCount, personCount);
        char[][] ladders = ladderController.getLadder();

        OutputView.outputResult(ladders);

    }

}
