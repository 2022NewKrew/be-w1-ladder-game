package laddergame.domain;

import laddergame.view.UIprinter;

import java.util.ArrayList;
import java.util.Random;
import java.util.List;

public class Line{
    private int colNum;             // 사다리의 넓이
    private List<Boolean> lines;    // 사다리의 가로줄 List

    Line(){}
    Line(int col){
        this.colNum = col;
        this.lines = new ArrayList<Boolean>();
        this.makeLine();            // 사다리의 가로줄 긋기
    }

    public List<Boolean> getLines(){
        return this.lines;
    }

    //----------------------------------------------------
    // 1. 사다리의 사이에 선을 긋기 위한 메소드들

    // 사다리의 특정위치에서 확률적으로 연결유무를 반환하는 메소드
    public boolean isConnected(int col){
        Random random = new Random();
        if(col>0 && this.lines.get(col-1))
            return false;
        return random.nextBoolean();
    }

    // 사다리의 한 행을 훑으며 선을 긋는 메소드
    private void makeLine(){
        for(int col=0; col<this.colNum; col++)
            this.lines.add(isConnected(col));
    }
    //----------------------------------------------------


    // 사다리의 한 행을 출력하는 메소드
    public void printRow(int lineLength){
        UIprinter ui = new UIprinter();
        ui.printRow(this.lines, this.colNum, lineLength);
    }
}