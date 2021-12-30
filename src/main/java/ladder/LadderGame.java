package ladder;

import ladder.domain.Ladder;
import ladder.domain.LadderInput;
import ladder.view.ViewLadder;

public class LadderGame {
    public static void main(String[] args) throws Exception {

        LadderInput li = new LadderInput();
        Ladder ladder = new Ladder(li.getLadderInputData());
        ViewLadder vLadder = new ViewLadder(ladder, 5, li.getNames(), li.getResults());
        vLadder.printLadder();
    }
}

