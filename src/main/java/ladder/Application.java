package ladder;

import ladder.domain.Ladder;
import ladder.view.InputView;
import ladder.view.OutputView;

public class Application {

    public static void main(String[] args) {
        int person = InputView.inputPerson();
        int ladder = InputView.inputLadder();

        LadderController ladderController = new LadderController(person, ladder);
        Ladder result = ladderController.result();
        OutputView.printResult(result);
    }
}
