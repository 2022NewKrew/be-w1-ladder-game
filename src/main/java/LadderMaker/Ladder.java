package LadderMaker;

import java.util.ArrayList;
import java.util.stream.Stream;

public class Ladder {
    private final int heightOfLadder;
    private final int numOfPeople;
    private final ArrayList<Line> connectedInfo;
    private final ArrayList<String> nameOfPeople;

    public Ladder(int heightOfLadder, ArrayList<String> nameOfPeople){
        this.heightOfLadder = heightOfLadder;
        this.nameOfPeople = nameOfPeople;
        this.numOfPeople = nameOfPeople.size();

        connectedInfo = new ArrayList<>(heightOfLadder);
    }

    public void addConnectedInfo(Line line) { connectedInfo.add(line); }
    //public void setConnectedInfo(int row, int column, Boolean data){ connectedInfo.get(row).set(column, data); }
    //public boolean getConnectedInfo(int row, int column){ return connectedInfo.get(row).getElement(column); }
    //public String getNameOfPeople(int idx){ return nameOfPeople.get(idx); }
    public int getNumOfPeople() { return numOfPeople; }
    public int getHeightOfLadder(){ return heightOfLadder; }
    public Stream<String> getNameStream(){ return nameOfPeople.stream(); }
    public Stream<Boolean> getConnectedStream(int row) { return connectedInfo.get(row).getLineStream(); }
}
