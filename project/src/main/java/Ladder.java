import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private int countOfPerson;
    private int height;
    private List<Line> lines;

    public Ladder(int countOfPerson, int height){
        this.countOfPerson = countOfPerson;
        this.height = height;
        lines = new ArrayList<Line>();
        for(int i = 0; i<height; i++){
            lines.add(new Line(countOfPerson));
        }
    }

    public void print(){
        for(Line line : lines) {
            System.out.println(line.toString());
        }
    }
}
