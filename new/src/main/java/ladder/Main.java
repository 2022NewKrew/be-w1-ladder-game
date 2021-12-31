package ladder;

import ladder.domain.Ladder;
import ladder.domain.LadderConfig;
import ladder.view.IO;


public class Main {
    public static void main(String[] args) {

        IO ioDriver = new IO();
        LadderConfig ladderConfig= ioDriver.getInput();
        Ladder ladder = new Ladder(ladderConfig);
        ioDriver.printLadder(ladder);

    }
}

