package ladder;

import ladder.domain.Ladder;
import ladder.domain.LadderBuilder;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> names = InputView.inputName();
        int height = InputView.inputHeight();

        LadderBuilder ladderBuilder = new LadderBuilder(names.size(), height);
        Ladder ladder = ladderBuilder.makeLadder();
        ResultView.printName(names);
        ResultView.printLadder(ladder.getLadder());
    }
}
