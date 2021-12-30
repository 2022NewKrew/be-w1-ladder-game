package ladder.domain;

import java.util.*;

public class Ladder {
    private final int numOfPeople;
    private final int depth;
    private final ArrayList<Line> ladder = new ArrayList<>();


    public Ladder(ArrayList<Integer> ladderInputData){
        this.numOfPeople = ladderInputData.get(0);
        this.depth = ladderInputData.get(1);
        setLadder();
    }


    private void setLadder(){
        for(int i=0;i<depth;i++){
            Line line = new Line(numOfPeople);
            ladder.add(line);
        }
    }

    public ArrayList<Line> getLadder(){ return ladder; }

}