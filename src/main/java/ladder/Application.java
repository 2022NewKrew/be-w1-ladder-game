package ladder;

import ladder.domain.Ladder;
import ladder.view.InputView;
import ladder.view.OutputView;

public class Application {

    public static void main(String[] args) {
        int countOfPerson = InputView.inputCountOfPerson();
        int ladderHeight = InputView.inputLadderHeight();

        LadderController ladderController = new LadderController(countOfPerson, ladderHeight);
        Ladder result = ladderController.result();
        OutputView.printLadder(result);
    }
}
