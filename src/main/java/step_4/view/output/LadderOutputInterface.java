package step_4.view.output;

import step_4.domain.Ladder;
import step_4.dto.LadderInfo;

public class LadderOutputInterface implements OutputInterface {
    @Override
    public void print(LadderInfo ladderInfo, Ladder ladder) {
        System.out.println("실행결과");
        ladder.printLadder();
    }
}
