package step_3.view.output;

import step_3.domain.Ladder;
import step_3.dto.LadderInfo;

public class LadderOutputInterface implements OutputInterface {
    @Override
    public void print(LadderInfo ladderInfo, Ladder ladder) {
        System.out.println("실행결과");
        ladder.printLadder();
    }
}
