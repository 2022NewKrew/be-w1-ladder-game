package keith;

import keith.domain.Ladder;
import keith.view.*;

public class Main {
    public static void main(String[] args) {
        InputManager im = new InputManager();
        OutputManager om = new OutputManager();
        im.getInput();

        Ladder ladder = new Ladder(im.getParticipants(), im.getHeight());
        LadderToString l2s = new LadderToString(ladder);
        om.println(l2s.toString());
    }
}
