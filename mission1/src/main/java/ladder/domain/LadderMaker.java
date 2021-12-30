package ladder.domain;

import ladder.entity.LadderInfo;
import ladder.entity.LadderInput;

import java.util.ArrayList;
import java.util.Random;

public class LadderMaker {
    private final Random random;
    private final LadderInput ladderInput;
    private final LadderInfo ladderInfo;

    public LadderMaker(LadderInput ladderInput) {
        this.ladderInput = ladderInput;

        random = new Random();

        ArrayList<Line> ladder = makeLadder();
        ladderInfo = new LadderInfo(ladder);
    }

    public LadderInfo getLadderInfo() {
        return ladderInfo;
    }

    private ArrayList<Line> makeLadder(){
        ArrayList<Line> ladder = new ArrayList<>();
        int numOfPlayer = ladderInput.getPlayerList().size();

        for (int i=0; i < ladderInput.getMaxHeight(); i++) {
            ladder.add(makeLine(numOfPlayer));
        }

        return ladder;
    }

    private Line makeLine(int numOfPlayer) {
        return new Line(numOfPlayer, random);
    }
}
