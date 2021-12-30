package LadderGame.domain.Ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {
    private final int ladderWidth;
    private final Random random = new Random();
    public List<Boolean> chkLadder = new ArrayList<>();
    public List<String> ladderComponents = new ArrayList<>();

    public Line(int ladderWidth) {
        this.ladderWidth = ladderWidth;
        makeLineInfo();
    }

    private void makeLineInfo(){
        for (int col = 0; col < ladderWidth; col++){
            boolean hasLadder = makeRandomLadder(col);
            chkLadder.add(hasLadder);
            makeLadderComponents(hasLadder);
        }
    }

    private Boolean makeRandomLadder(int col){
        if(canMakeRandomLadder(col)){
            return false;
        }
        return random.nextBoolean();
    }

    private Boolean canMakeRandomLadder(int col){
        return isLastIndex(col) || isBeforeIndexHasLadder(col);
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
