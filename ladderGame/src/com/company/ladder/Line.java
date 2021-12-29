package com.company.ladder;

import java.util.ArrayList;
import java.util.Random;

public class Line {
    static final Random random = new Random();
    ArrayList<Boolean> steps;

    public Line(int attendantNum){
        steps = new ArrayList<>();

        for(int lineIndex = 0; lineIndex < attendantNum; lineIndex++){
            steps.add(getNewStep(lineIndex));
        }
    }

    public void printLine(){
        System.out.printf("  |");

        for(boolean stepExistence : steps){
            System.out.printf(getOneStep(stepExistence));
        }
        
        System.out.println();
    }


    private boolean getNewStep(int lineIndex) {
        Boolean isPrevStepExist = lineIndex > 0 && steps.get(lineIndex -1);
        if(isPrevStepExist){
            return false;
        }
        return random.nextBoolean();
    }

    private String getOneStep(boolean stepExistence) {
        if(stepExistence){
            return "-----|";
         }
        return "     |";
    }

}
