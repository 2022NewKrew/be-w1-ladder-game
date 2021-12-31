import java.util.ArrayList;


public class Ladder {
    private final int nPeople;
    private final int maxHeight;
    private final String[] peopleNames;
    private final ArrayList<Line> arr;


    private static final int maxNameLength = 5;

    //constructor
    public Ladder(LadderConfig ladderConfig) {
        this.nPeople = ladderConfig.getNumPeople();
        this.maxHeight = ladderConfig.getMaxHeight();
        this.peopleNames = ladderConfig.getPeopleNames();
        this.arr = new ArrayList<Line>();

        buildLines();
    }


    public String[] getPeopleNames() {
        return this.peopleNames;
    }

    public int getMaxNameLength() {
        return maxNameLength;
    }

    public ArrayList<Line> getLadderList() {
        return this.arr;
    }

    //line 생성
    public void buildLines() {
        for (int i = 0; i < this.maxHeight; i++) {
            Line line = new Line(this.nPeople);
            this.arr.add(line);
        }
    }

}
