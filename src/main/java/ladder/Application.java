package ladder;

import java.io.IOException;
import java.util.ArrayList;
import ladder.controller.LadderController;
import ladder.domain.Ladder;
import ladder.domain.Person;
import ladder.view.InputView;
import ladder.view.OutputView;

public class Application {
    public static void main(String[] args) throws IOException {
        final ArrayList<Person> persons = InputView.inputPerson();
        final int countOfPerson = persons.size();
        final int ladderHeight = InputView.inputLadderHeight();

        final LadderController ladderController = new LadderController(countOfPerson,ladderHeight);
        final Ladder ladder = ladderController.getLadder();
        OutputView.printPerson(persons);
        OutputView.printLadder(ladder);
    }
}