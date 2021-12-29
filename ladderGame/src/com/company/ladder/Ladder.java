package com.company.ladder;

import java.util.Random;

public class Ladder {
    Random random = new Random();
    int attendantNum;
    int ladderHeight;
    boolean[][] ladderArray = null;

    public Ladder(){
        attendantNum = 0;
        ladderHeight = 0;
        ladderArray = new boolean[0][0];
    }

    public Ladder(int attendantNum, int ladderHeight){
        this.attendantNum = attendantNum - 1;
        this.ladderHeight = ladderHeight;
        ladderArray = new boolean[attendantNum - 1][ladderHeight];
    }

    public void makeLadder(){
        for(int attendentIndex = 0; attendentIndex < attendantNum; attendentIndex++){
            makeOneLineLadder(attendentIndex);
        }
    }

    public void printLadder(){
        for(int ladderIndex = 0; ladderIndex < ladderHeight; ladderIndex++){
            printOneLineLadder(ladderIndex);
        }
    }

    private void makeOneLineLadder(int attendentIndex) {
        for(int ladderIndex = 0; ladderIndex < ladderHeight; ladderIndex++){
            ladderArray[attendentIndex][ladderIndex] = makeOneLadder(attendentIndex, ladderIndex);
        }
    }

    private boolean makeOneLadder(int attendentIndex, int ladderIndex) {
        boolean isPrevLadder = attendentIndex == 0 || (attendentIndex > 0 && !ladderArray[attendentIndex-1][ladderIndex]);
        if(isPrevLadder){
            return random.nextBoolean();
        }
        return false;
    }


    private void printOneLineLadder(int ladderIndex) {
        for(int attendantIndex = 0; attendantIndex < attendantNum; attendantIndex++){
            System.out.printf(getLadderExist(attendantIndex, ladderIndex));
        }
        System.out.printf("|\n");
    }

    private String getLadderExist(int attendentIndex, int ladderIndex) {
        if(ladderArray[attendentIndex][ladderIndex]){
            return "|-";
        }
        return "| ";
    }
}
