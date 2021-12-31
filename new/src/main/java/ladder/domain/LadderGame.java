package ladder.domain;

import java.util.ArrayList;

public class LadderGame {
    private final ArrayList<Line> ladderArr;

    public LadderGame(ArrayList<Line> ladderArr){
        this.ladderArr = ladderArr;
    }

    public int getResultIdx(int pos){

        for(Line line : this.ladderArr){
            pos = move(line.getCells(), pos);
        }
        return pos;
    }

    private static int move(ArrayList<Boolean> line, int pos){
        if(pos==0){
            int moving = line.get(pos) ? 1 : 0;
            return pos + moving;
        }
        if(line.get(pos)){
            return pos +1;
        }
        if(line.get(pos-1)){
            return pos -1;
        }
        return pos;
    }
}
