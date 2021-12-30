package com.company.view;

import com.company.ladder.Line;

public class ConsoleView implements PrintInterface{
    @Override
    public void printName(String name) {
        System.out.printf(name + " ");
    }

    @Override
    public void printStep(boolean isExist) {
        System.out.printf(getOneStep(isExist));
    }

    @Override
    public void printStick(boolean isLastStick) {
        System.out.printf(getOneStick(isLastStick));
    }

    private String getOneStep(boolean isExist){
        if(isExist) return "-----";
        return "     ";
    }

    private String getOneStick(boolean isLastStick){
        if(isLastStick) return "|\n";
        return "|";
    }
}
