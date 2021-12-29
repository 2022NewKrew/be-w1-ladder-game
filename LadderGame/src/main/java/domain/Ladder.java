package domain;

import java.util.ArrayList;

public class Ladder {
    private ArrayList<Line> map;

    public Ladder(int peopleNum, int height){
        map = new ArrayList<Line>();
        this.setMap(peopleNum, height);
    }
        public void setMap(int peopleNum, int height){
        for(int i = 0; i < height; i++){
            this.map.add(new Line(peopleNum));
        }
    }

    public void showMap(){
        for(Line line : map) {
            System.out.println(line);
        }
    }
}