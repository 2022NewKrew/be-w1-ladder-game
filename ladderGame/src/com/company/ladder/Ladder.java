package com.company.ladder;


import java.util.ArrayList;

import java.util.Random;

public class Ladder {
    Random random = new Random();
    int attendantNum;
    int ladderHeight;
    ArrayList<Line> ladderArray;


    public Ladder(){
        attendantNum = 0;
        ladderHeight = 0;
        ladderArray = new ArrayList<>();

    }

    public Ladder(int attendantNum, int ladderHeight){
        this.attendantNum = attendantNum - 1;
        this.ladderHeight = ladderHeight;
        ladderArray = new ArrayList<>();

    }

    public void makeLadder(){
        for(int ladderIndex = 0; ladderIndex < ladderHeight; ladderIndex++){
            ladderArray.add(new Line(attendantNum));
        }
    }

    public void printLadder(){
        for(int ladderIndex = 0; ladderIndex < ladderHeight; ladderIndex++){
            ladderArray.get(ladderIndex).printLine();
        }

    }
}
