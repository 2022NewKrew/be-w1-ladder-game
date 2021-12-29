package laddergame;

import java.util.Random;

class Line{
    private int colNum;
    private int rowNum;
    private boolean[][] line;

    Line(){}
    Line(int col, int row){
        this.colNum = col;
        this.rowNum = row;
        this.line = new boolean[col][row];
    }

    //////////////////////////////////////////////////////
    // 1. 사다리의 사이에 선을 긋기 위한 메소드들

    // 사다리의 특정위치에서 확률적으로 연결유무를 반환하는 메소드
    public boolean isConnected(int col, int row){
        Random random = new Random();
        if(col>0 && this.line[col-1][row]){
            return false;
        }
        return random.nextBoolean();
    }

    // 사다리의 한 행을 훑으며 선을 긋는 메소드
    public void drawRow(int row){
        for(int col=0; col<this.colNum; col++)
            this.line[col][row] = isConnected(col,row);
    }

    // 사다리 사이 선긋기 메소드
    public void makeLine(){
        Random random = new Random();
        for(int row=0; row<this.rowNum; row++){
            this.drawRow(row);
        }
    }
    //////////////////////////////////////////////////////


    //////////////////////////////////////////////////////
    // 2. 사다리의 한 행을 출력하기 위한 메소드들

    // 사다리의 특정 위치에서의 선의 유무에 따른 선 출력
    public void printLine(int col, int row){
        if(this.line[col][row]){
            System.out.print("-");
            return;
        }
        System.out.print(" ");
    }

    // 사다리의 한 행을 출력하는 메소드
    public void printRow(int row){
        for(int col=0; col<this.colNum; col++){
            System.out.print("|");
            this.printLine(col,row);
        }
        System.out.print("|\n");
    }
    //////////////////////////////////////////////////////
}