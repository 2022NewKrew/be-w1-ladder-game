package com.company.ladder;

import java.util.Random;

public class Ladder {
    private int attendantNum;
    private int ladderNum;
    private boolean ladder[][] = null;

    public Ladder(int attendantNum, int ladderNum){
        this.attendantNum = attendantNum;
        this.ladderNum = ladderNum;
        assignArray();
    }

    private void assignArray(){
        ladder = new boolean[ladderNum][];
        for(int i = 0; i < ladderNum; i++){
            ladder[i] = new boolean[attendantNum];
        }
    }

    public void makeRandomLadder(){
        for(int i = 0; i < ladderNum; i++){
            for(int j = 0; j < attendantNum; j++){
                ladder[i][j] = isPrevLadder(i,j);
            }
        }
    }

    private boolean isPrevLadder(int i, int j) {
        Random random = new Random();

        boolean prevLadderExist = j == 0 || (j > 0 && !ladder[i][j-1]);
        if(prevLadderExist) {
            return random.nextBoolean();
        }
        return false;
    }

    public void print(){
        for(int i = 0; i < ladderNum; i++){
            drawOneLine(i);
        }
    }

    private void drawOneLine(int index) {
        System.out.printf("|");
        for(int i = 0; i < attendantNum; i++){
            System.out.printf(drawLadder(index, i));
        }
        System.out.printf("\n");
    }

    private String drawLadder(int i, int j) {
        if(ladder[i][j]){
            return "-|";
        }
        return " |";
    }
}
