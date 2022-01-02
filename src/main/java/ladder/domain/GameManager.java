package ladder.domain;

import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.ArrayList;

public class GameManager {
    private static ArrayList<String> names;
    private static ArrayList<String> ladderResults;
    private static int height;
    private static Ladder ladder;

    private static void inputInfo() {
        names = InputView.inputName();
        Validation.validateNames(names);
        ladderResults = InputView.inputLadderResult();
        Validation.validateLadderResults(ladderResults, names.size());
        height = InputView.inputHeight();
        Validation.validateHeight(height);
    }

    private static void buildLadder() {
        LadderBuilder ladderBuilder = new LadderBuilder(names.size(), height);
        ladder = ladderBuilder.makeLadder();
    }

    private static void viewGameResult() {
        ResultView.printGameResultMessage();
        ResultView.printNameOrResult(names);
        ResultView.printLadder(ladder.getLadder());
        ResultView.printNameOrResult(ladderResults);
    }

    public static void startGame() {
        inputInfo();
        buildLadder();
        viewGameResult();
    }
}
