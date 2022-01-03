package view.output;

import domain.Ladder;
import dto.LadderInfo;

public class LadderOutputInterface implements OutputInterface {
    @Override
    public void print(LadderInfo ladderInfo, Ladder ladder) {
        System.out.println("실행결과");
        ladder.printLadder();
    }
}
