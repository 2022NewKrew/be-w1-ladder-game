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
        this.points = makeHasRightLadderLine();
    }

    private ArrayList<Boolean> makeHasRightLadderLine(){
        ArrayList<Boolean> points = new ArrayList<>();
        for (int ladderCol = 0; ladderCol < ladderWidth-1; ladderCol++){
            points.add(random.nextBoolean());
        }
        return points;
    }
}
