package LadderGame.domain.Ladder;

import LadderGame.util.RandomUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {
    private final int ladderWidth;
    private final List<Integer> connectionPoints;
    private final List<LadderShape> ladderShape;

    public Line(int ladderWidth) {
        this.ladderWidth = ladderWidth;
        this.connectionPoints = new ArrayList<>(Collections.nCopies(ladderWidth, -1));
        this.ladderShape = new ArrayList<>();
        makeLineInfo();
    }

    private void makeLineInfo(){
        for (int col = 0; col < ladderWidth; col++){
            boolean hasLadder = makeRandomLadder(col);
            setLadderConnectionPoints(hasLadder, col);
            makeLadderShape(hasLadder);
        }
    }

    private void setLadderConnectionPoints(boolean hasLadder, int col){
        if(hasLadder){
            this.connectionPoints.set(col, col + 1);
            this.connectionPoints.set(col+1, col);
        }
    }

    private Boolean makeRandomLadder(int col){
        if(isLastIndex(col) || isBeforeIndexHasLadder(col)){
            return false;
        }
        return RandomUtil.getRandomBoolean();
    }

    private Boolean isLastIndex(int col){
        return col == ladderWidth - 1;
    }

    private Boolean isBeforeIndexHasLadder(int col){
        return connectionPoints.get(col) != -1;
    }

    private void makeLadderShape(boolean hasLadder){
        ladderShape.add(LadderShape.VERTICAL_LINE);
        ladderShape.add(getLadderShape(hasLadder));
    }

    private LadderShape getLadderShape(boolean hasLadder){
        if(hasLadder){
            return LadderShape.HORIZONTAL_LINE;
        }
        return LadderShape.BLANK;
    }

    public List<Integer> getConnectionPoints() {
        return connectionPoints;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ladderShape.forEach((shape) -> sb.append(shape.getShape()));
        return sb.toString();
    }
}
