package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

    private boolean randomValue(int index){
        if(checkCollision(index))
            return false;

        Random random = new Random();
        return random.nextBoolean();
    }

    private boolean checkCollision(int index){
        return index > 0 && line.get(index - 1);
    }
}
