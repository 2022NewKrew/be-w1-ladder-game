import java.util.ArrayList;
import java.util.Scanner;

public class Ladder {
    private ArrayList<Line> map;
    private int width;
    private int height;

    Ladder(int peopleNum, int height){
        map = new ArrayList<Line>();
        this.width = peopleNum;
        this.height = height;
    }

    public void setMap(){
        for(int i = 0; i < this.height; i++){
            this.map.add(new Line(this.width));
        }
    }

    public void showMap(){
        System.out.println("실행결과");
        System.out.println();
        for(Line line : map) {
            System.out.println(line);
        }
    }
}
