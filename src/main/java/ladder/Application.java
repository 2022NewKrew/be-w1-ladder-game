package ladder;

import ladder.controller.LadderController;
import ladder.domain.Ladder;
import ladder.domain.Person;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        ArrayList<Person> people = InputView.inputPerson();
        int personCount = people.size();
        int ladderCount = InputView.inputLadderCount();

        LadderController ladderController = new LadderController(ladderCount, personCount);
        Ladder ladder = ladderController.getLadder();

        OutputView.outputPerson(people);
        OutputView.outputLadder(ladder);
    }
}
