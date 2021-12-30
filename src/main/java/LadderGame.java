import domain.Ladder;
import domain.LadderFactory;
import view.InputView;
import view.OutputView;

import java.util.List;

public class LadderGame {

    public static void main(String[] args) {
        List<String> people, results;
        int height;

        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        people = inputView.getPeople();
        results = inputView.getResults();
        height = inputView.getHeight();

        Ladder ladder = LadderFactory.buildLadder(people.size(), height);

        outputView.printPeople(people);
        outputView.printLadder(ladder);
        outputView.printResults(results);
    }
}
