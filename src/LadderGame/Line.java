package LadderGame;

import java.util.ArrayList;
import java.util.Random;

public class Line {
    private final int ladderWidth;
    private final Random random;
    public ArrayList<Boolean> points;

    public Line(int ladderWidth, Random randomInstance) {
        this.ladderWidth = ladderWidth;
        this.random = randomInstance;
        makeHasRightLadderLine();
    }

    private void makeHasRightLadderLine(){
        points = new ArrayList<>();
        for (int ladderCol = 0; ladderCol < ladderWidth-1; ladderCol++){
            points.add(makeValue(ladderCol));
        }
    }

    private Boolean makeValue(int col){
        if(col != 0 && points.get(col-1)){
            return false;
        }
        return random.nextBoolean();
    }
}
