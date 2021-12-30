package LadderGame.domain.Ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {
    private final int ladderWidth;
    private final Random random;
    public List<Boolean> chkLadder;
    public List<String> ladderComponents;

    public Line(int ladderWidth, Random randomInstance) {
        this.ladderWidth = ladderWidth;
        this.random = randomInstance;
        makeLineInfo();
    }

    private void makeLineInfo(){
        chkLadder = new ArrayList<>();
        ladderComponents = new ArrayList<>();

        for (int col = 0; col < ladderWidth; col++){
            boolean hasLadder = makeLadder(col);
            chkLadder.add(hasLadder);
            makeLadderComponents(hasLadder);
        }
    }

    private Boolean makeLadder(int col){
        if(isLastIndex(col) || isBeforeIndexHasLadder(col)){
            return false;
        }
        return random.nextBoolean();
    }

    private Boolean isLastIndex(int col){
        return col == ladderWidth - 1;
    }

    private Boolean isBeforeIndexHasLadder(int col){
        return col != 0 && chkLadder.get(col - 1);
    }

    private void makeLadderComponents(boolean hasLadder){
        ladderComponents.add(LadderShape.VERTICAL_LINE.getShape());
        ladderComponents.add(getLadderShape(hasLadder).getShape());
    }

    private LadderShape getLadderShape(boolean hasLadder){
        if(hasLadder){
            return LadderShape.HORIZONTAL_LINE;
        }
        return LadderShape.BLANK;
    }
}
