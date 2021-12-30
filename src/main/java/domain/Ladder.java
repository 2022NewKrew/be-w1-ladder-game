package domain;

import java.util.ArrayList;

public class Ladder {
    private ArrayList<Line> lines;

    public Ladder(int peopleNum, int height){
        lines = new ArrayList<Line>();
        this.generateMap(peopleNum, height);
    }

    private void generateMap(int peopleNum, int height){
        for(int i = 0; i < height; i++){
            this.lines.add(new Line(peopleNum));
        }
    }

    public ArrayList<Line> getLines(){
        return lines;
    }

    public int getResultIndex(int index){
        int height = lines.size();
        int curindex = index;
        for(int i = 0; i < height; i++){
            Line curLine = lines.get(i);
            curindex = curLine.getNextIndex(curindex);
        }
        return curindex;
    }
}