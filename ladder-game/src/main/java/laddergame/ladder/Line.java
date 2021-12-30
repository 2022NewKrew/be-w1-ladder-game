package laddergame.ladder;

import java.util.ArrayList;
import java.util.Random;

public class Line {
    private ArrayList<Boolean> line;
    private static Random randomGenerator = new Random();

    public Line(int countOfPerson){
        line = new ArrayList<>();

        for (int i=0;i<countOfPerson-1;i++){
            line.add(haveLine(i));
        }
    }

    public ArrayList<Boolean> getLine(){
        return line;
    }

    public boolean haveLine(int idx){
        if (haveBeside(idx)){
            return false;
        }
        boolean randomBool = randomGenerator.nextBoolean();
        return randomBool;
    }

    public boolean haveBeside(int idx){
        return (idx>0 && line.get(idx-1));
    }
}
