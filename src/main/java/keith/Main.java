package keith;

import keith.domain.Ladder;
import keith.io.*;

public class Main {

    public static void main(String[] args) {
        InputManager im = new InputManager();
        OutputManager om = new OutputManager();

        Ladder ladder = im.getLadderInput();
        om.printLadder(ladder);
    }
}
