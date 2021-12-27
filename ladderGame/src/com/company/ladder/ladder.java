package com.company.ladder;

import java.util.Random;

public class ladder {
    private int attendant_num;
    private int ladder_num;
    private boolean ladder[][] = null;

    private void assignArray(){
        ladder = new boolean[ladder_num][];
        for(int i = 0; i < ladder_num; i++){
            ladder[i] = new boolean[attendant_num];
        }
    }

    public ladder(int attendant_num, int ladder_num){
        this.attendant_num = attendant_num;
        this.ladder_num = ladder_num;
        assignArray();
    }

    public void makeRandomLadder(){
        Random random = new Random();

        for(int i = 0; i < ladder_num; i++){
            boolean prev_ladder = false;
            for(int j = 0; j < attendant_num; j++){
                if(!prev_ladder) {
                    ladder[i][j] = random.nextBoolean();
                    prev_ladder = ladder[i][j];
                }
                else{
                    prev_ladder=false;
                }
            }
        }
    }
    public void print(){
        for(int i = 0; i < ladder_num; i++){
            System.out.printf("|");
            for(int j = 0; j < attendant_num; j++){
                drawladder(i, j);
            }
            System.out.printf("\n");
        }
    }

    private void drawladder(int i, int j) {
        if(ladder[i][j]){
            System.out.printf("-");
        }
        else{
            System.out.printf(" ");
        }
        System.out.printf("|");
    }
}
