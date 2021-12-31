package ladder;

import ladder.domain.Ladder;
import ladder.domain.LadderBuilder;
import ladder.domain.Validation;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> names = InputView.inputName();
        Validation.validateNames(names);
        int height = InputView.inputHeight();
        Validation.validateHeight(height);

        LadderBuilder ladderBuilder = new LadderBuilder(names.size(), height);
        Ladder ladder = ladderBuilder.makeLadder();
        ResultView.printName(names);
        ResultView.printLadder(ladder.getLadder());
    }
}
