package ladder;

import java.io.IOException;
import ladder.controller.LadderController;
import ladder.domain.Ladder;
import ladder.view.InputView;
import ladder.view.OutputView;

public class Application {
    public static void main(String[] args) throws IOException {
        final int countOfPerson = InputView.inputCountOfPerson();
        final int ladderHeight = InputView.inputLadderHeight();

        final LadderController ladderController = new LadderController(countOfPerson,ladderHeight);
        final Ladder ladder = ladderController.getLadder();
        OutputView.printLadder(ladder);
    }
}