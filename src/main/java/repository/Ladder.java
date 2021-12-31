package repository;

import java.util.List;
import java.util.stream.Stream;

public class Ladder {
    private final int heightOfLadder;
    private final int numOfPeople;
    private final List<String> names;
    private final List<String> results;
    private List<Line> connectedInfo;

    public Ladder(int heightOfLadder, List<String> names, List<String> results){
        this.heightOfLadder = heightOfLadder;
        this.names = names;
        this.results = results;
        this.numOfPeople = names.size();
    }

    public int getMaxResultLength(){
        return results.stream()
                .mapToInt(String::length)
                .max()
                .orElse(0);
    }

    public void addConnectedInfo(List<Line> connectedInfo) { this.connectedInfo = connectedInfo; }
    public int getNumOfPeople() { return numOfPeople; }
    public int getHeightOfLadder(){ return heightOfLadder; }
    public Stream<Point> getConnectedStream(int row) { return connectedInfo.get(row).getLineStream(); }
    public Stream<String> getNameStream() { return names.stream(); }
    public Stream<String> getResultStream() { return results.stream(); }
}
