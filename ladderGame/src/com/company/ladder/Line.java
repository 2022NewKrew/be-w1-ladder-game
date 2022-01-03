package com.company.ladder;

import com.company.view.PrintInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {
    static final Random random = new Random();
    private List<Boolean> steps;

    public Line(){
        steps = new ArrayList<>();
    }

    public void setLine(int attendantNum) {
        for(int lineIndex = 0; lineIndex < attendantNum; lineIndex++){
            steps.add(getNewStep(lineIndex));
        }
    }

    public void printLine(PrintInterface printInterface){
        for(boolean stepExistence : steps){
            printInterface.printStick(false);
            printInterface.printStep(stepExistence);
        }
        printInterface.printStick(true);
    }

    public boolean getNewStep(int lineIndex) {
        boolean isPrevStepExist = lineIndex > 0 && steps.get(lineIndex -1);
        if(isPrevStepExist){
            return false;
        }
        return random.nextBoolean();
    }

    public boolean getStep(int lineIndex){
        return steps.get(lineIndex);
    }
}
