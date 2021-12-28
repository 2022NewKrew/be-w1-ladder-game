package com.company.ladder;

import java.util.Random;

public class Ladder {
    private int attendantNum;
    private int ladderNum;
    private boolean ladder[][] = null;
    private static final Random random = new Random();


    public Ladder(int attendantNum, int ladderNum){
        this.attendantNum = attendantNum;
        this.ladderNum = ladderNum;
        ladder = new boolean[ladderNum][attendantNum];
    }

    public void makeRandomLadder(){
        for(int ladderIndex = 0; ladderIndex < ladderNum; ladderIndex++){
            makeOneLineLadder(ladderIndex);
        }
    }

    private void makeOneLineLadder(int ladderIndex) {
        for(int attendantIndex = 0; attendantIndex < attendantNum; attendantIndex++){
            ladder[ladderIndex][attendantIndex] = getNewLadder(ladderIndex,attendantIndex);
        }
    }

    private boolean getNewLadder(int ladderIndex, int attendantIndex) {
        boolean isPrevLadder = attendantIndex == 0 || (attendantIndex > 0 && !ladder[ladderIndex][attendantIndex-1]);
        if(isPrevLadder) {
            return random.nextBoolean();
        }
        return false;
    }

    public void print(){
        for(int ladderIndex= 0; ladderIndex < ladderNum; ladderIndex++){
            drawOneLine(ladderIndex);
        }
    }

    private void drawOneLine(int ladderIndex) {
        System.out.printf("|");
        for(int attendantIndex = 0; attendantIndex < attendantNum; attendantIndex++){
            System.out.printf(drawLadder(ladderIndex, attendantIndex));
        }
        System.out.printf("\n");
    }

    private String drawLadder(int ladderIndex, int attendantIndex) {
        if(ladder[ladderIndex][attendantIndex]){
            return "-|";
        }
        return " |";
    }
}
