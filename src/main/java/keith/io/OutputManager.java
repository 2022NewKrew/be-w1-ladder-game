package keith.io;

import keith.domain.Ladder;
import keith.view.LadderToString;

public class OutputManager {
    public void printLadder(Ladder ladder) {
        LadderToString l2s = new LadderToString(ladder);

        System.out.println("실행 결과");
        System.out.println(l2s);
    }
}
