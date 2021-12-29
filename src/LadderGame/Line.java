package LadderGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {
    private final static String VERTICAL_LINE = "|";
    private final static String HORIZONTAL_LINE = "-----";
    private final static String BLANK = "     ";

    private final int ladderWidth;
    private final Random random;
    public List<Boolean> chkLadder;
    public List<String> ladderComponents;

    public Line(int ladderWidth, Random randomInstance) {
        this.ladderWidth = ladderWidth;
        this.random = randomInstance;
        makeLadder();
    }

    private void makeLadder(){
        chkLadder = new ArrayList<>();
        ladderComponents = new ArrayList<>();

        for (int col = 0; col < ladderWidth; col++){
            boolean hasLadder = chkLadderCol(col);
            chkLadder.add(hasLadder);
            makeLadderComponents(hasLadder);
        }
    }

    private Boolean chkLadderCol(int col){
        if(col == ladderWidth-1 || (col != 0 && chkLadder.get(col-1))){
            return false;
        }
        return random.nextBoolean();
    }

    private void makeLadderComponents(boolean hasLadder){
        ladderComponents.add(VERTICAL_LINE);
        if(hasLadder){
            ladderComponents.add(HORIZONTAL_LINE);
        }else{
            ladderComponents.add(BLANK);
        }
    }
}
