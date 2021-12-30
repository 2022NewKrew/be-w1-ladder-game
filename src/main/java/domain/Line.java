package domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final List<Boolean> line;

    public Line(int numOfPerson){
        line = new ArrayList<>();

        for(int i=0; i<numOfPerson-1; i++) {
            line.add(randomValue(i));
        }
    }

    public List<Boolean> getLine() {
        return line;
    }

    public boolean randomValue(int index){
        if(collisionCheck(index))
            return false;

        return (int)(Math.random()*2) == 1;
    }

    private boolean collisionCheck(int index){
        return index > 0 && line.get(index - 1);
    }
}
