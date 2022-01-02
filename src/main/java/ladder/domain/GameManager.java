package ladder.domain;

import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.ArrayList;

public class GameManager {
    static ArrayList<String> names;
    static int height;
    static Ladder ladder;

    private static void inputInfo() {
        names = InputView.inputName();
        Validation.validateNames(names);
        height = InputView.inputHeight();
        Validation.validateHeight(height);
    }

    private static void buildLadder() {
        LadderBuilder ladderBuilder = new LadderBuilder(names.size(), height);
        ladder = ladderBuilder.makeLadder();
    }

    private static void viewResult() {
        ResultView.printName(names);
        ResultView.printLadder(ladder.getLadder());
    }

    public static void startGame() {
        inputInfo();
        buildLadder();
        viewResult();
    }
}
