package LadderGame.domain.Ladder;

import LadderGame.util.RandomUtil;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final int ladderWidth;
    public List<Boolean> chkLadder = new ArrayList<>();
    public List<LadderShape> ladderShape = new ArrayList<>();

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
        return RandomUtil.getRandomBoolean();
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
        ladderShape.add(LadderShape.VERTICAL_LINE);
        ladderShape.add(getLadderShape(hasLadder));
    }

    private LadderShape getLadderShape(boolean hasLadder){
        if(hasLadder){
            return LadderShape.HORIZONTAL_LINE;
        }
        return LadderShape.BLANK;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ladderShape.forEach((shape) -> sb.append(shape.getShape()));
        return sb.toString();
    }
}
