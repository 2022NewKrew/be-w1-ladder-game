import java.util.ArrayList;

public class Ladder {
    private int countOfPerson;
    private int height;
    private ArrayList<Line> lines;

    public Ladder(int countOfPerson, int height){
        this.countOfPerson = countOfPerson;
        this.height = height;
        lines = new ArrayList<Line>();
        for(int i = 0; i<height; i++){
            lines.add(new Line(countOfPerson));
        }
    }

    public void printLadder(){
        for(int i = 0 ; i < lines.size() ; i++) {
            System.out.println(lines.get(i).printLine());
        }
    }
}
