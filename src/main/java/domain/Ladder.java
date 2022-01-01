package domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<Line> ladder;

    public Ladder(int numOfPerson, int height) {
        ladder = new ArrayList<>();

        for(int i=0; i<height; i++){
            ladder.add(new Line(numOfPerson));
        }
    }

    public List<Line> getLadder() {
        return ladder;
    }

    public int ladderResult(int startIndex){
        int curIndex = startIndex;
        for (Line line : ladder) {
            curIndex = nextIndex(line, curIndex);
        }
        return curIndex;
    }

    private int nextIndex(Line line, int index){
        if((index > 0) && line.getLine().get(index-1)){
            return index-1;
        }

        if((index < line.getLine().size()) && line.getLine().get(index)){
            return index+1;
        }

        return index;
    }

}
