import domain.Ladder;
import domain.LadderFactory;
import view.InputView;
import view.OutputView;

import java.util.List;

public class LadderGame {

    private static final String KEYWORD_EXIT = "춘식이";

    public static void main(String[] args) {
        List<String> people, results;
        int height;

        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        people = inputView.getPeople();
        results = inputView.getResults();
        height = inputView.getHeight();

        Ladder ladder = LadderFactory.buildLadder(people, results, height);

        outputView.printLadder(ladder);

        String resultQuery = null;
        while (!(KEYWORD_EXIT.equals(resultQuery))) {
            resultQuery = inputView.getResultQuery();
            outputView.printResult(ladder, resultQuery);
        }
    }
}
