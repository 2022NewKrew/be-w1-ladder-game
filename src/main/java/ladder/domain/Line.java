package ladder.domain;

import java.util.ArrayList;
import java.util.Random;

public class Line {
    private final int numOfStatus;
    private final Random rd = new Random();
    private ArrayList<Integer> line;


    Line(int numOfPeople){
        this.numOfStatus = numOfPeople-1;
        setLine();
    }


    private void setLine(){
        int previousStatusIdx = 1;
        int currentStatusIdx;
        line = new ArrayList<>();

        for(int i=0;i<numOfStatus;i++){
            currentStatusIdx = validCheck(previousStatusIdx);
            line.add(currentStatusIdx);
            previousStatusIdx = currentStatusIdx;
        }
    }

    private int validCheck(int previousIdx){
        if(previousIdx == 0) {
            return 1;
        }
        return rd.nextInt(2);
    }

    public ArrayList<Integer> getLine() {return line;}

}