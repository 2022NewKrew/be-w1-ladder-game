package laddergame.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder{
    private int width;      // 사다리의 넓이
    private int height;     // 사다리의 높이
    List<Line> lines;       // 사다리의 행의 리스트

    Ladder(){}
    Ladder(int w, int h){
        this.width = w;
        this.height = h;
        this.lines = new ArrayList<Line>();
        this.makeLines();   // 사다리의 가로줄 긋기
    }

    // 사다리의 가로줄을 긋는 메소드
    private void makeLines(){
        for(int row=0; row<this.height; row++)
            this.lines.add( new Line(this.width));
    }

    // 사다리 출력 메소드
    public void printLadder(int lineLength){
        for(Line line : this.lines)
            line.printRow(lineLength);
    }
}