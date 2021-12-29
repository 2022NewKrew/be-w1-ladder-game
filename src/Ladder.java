import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Ladder {
    private final int nPeople;
    private final int maxHeight;
    private final ArrayList<Line> arr;


    private static final int maxNameLength = 5;

    //constructor
    public Ladder(LadderConfig ladderConfig) {
        this.nPeople = ladderConfig.getNumPeople();
        this.maxHeight = ladderConfig.getMaxHeight();
        this.arr = new ArrayList<Line>();

        buildLines();

    }

    public int getMaxHeight() {
        return this.maxHeight;
    }

    public int getNumPeople() {
        return this.nPeople;
    }

    public int getMaxNameLength() {
        return maxNameLength;
    }

    public ArrayList<Line> getLadderList() {
        return this.arr;
    }

    //line 생성
    public void buildLines() {
        for(int i=0; i<this.maxHeight; i++){
            Line line = new Line(this.nPeople);
            this.arr.add(line);
        }
    }


}