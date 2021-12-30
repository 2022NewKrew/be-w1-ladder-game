package keith;

import keith.domain.Ladder;
import keith.io.*;

public class Main {
    public static final int MAX_NAME_LEN = 5;

    public static void main(String[] args) {
        InputManager im = new InputManager();
        OutputManager om = new OutputManager();

        Ladder ladder = im.getInput();
        om.printLadder(ladder);
    }
}
