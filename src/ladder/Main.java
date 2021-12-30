package ladder;

import ladder.domain.Ladder;
import ladder.domain.LadderConfig;
import ladder.view.IO;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        IO ioDriver = new IO();
        LadderConfig ladderConfig= ioDriver.getInput();
        Ladder ladder = new Ladder(ladderConfig);
        ioDriver.printLadder(ladder);

    }
}
