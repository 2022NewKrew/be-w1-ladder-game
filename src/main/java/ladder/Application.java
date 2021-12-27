package ladder;

import ladder.domain.Ladder;
import ladder.dto.LadderDto;
import ladder.view.InputView;
import ladder.view.OutputView;

public class Application {

    public static void main(String[] args) {
        final int countOfPerson = InputView.inputCountOfPerson();
        final int ladderHeight = InputView.inputLadderHeight();

        final LadderController ladderController = new LadderController(countOfPerson, ladderHeight);
        final Ladder ladder = ladderController.getLadder();
        OutputView.printLadder(LadderDto.ladderToDto(ladder));
    }
}
