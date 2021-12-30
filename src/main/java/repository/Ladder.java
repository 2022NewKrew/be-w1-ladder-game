package repository;

import repository.Line;
import repository.Player;
import repository.PlayerList;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Ladder {
    private final int heightOfLadder;
    private final int numOfPeople;
    private final List<Line> connectedInfo;
    private final List<String> results;
    private final PlayerList players;
    private final int MAX_RESULT_LENGTH;

    public Ladder(int heightOfLadder, PlayerList players, int maxResultLength, List<String> results){
        this.heightOfLadder = heightOfLadder;
        this.players = players;
        this.numOfPeople = players.getNumOfPeople();
        this.results = results;
        MAX_RESULT_LENGTH = maxResultLength;

        connectedInfo = new ArrayList<>(heightOfLadder);
    }

    public void addConnectedInfo(Line line) { connectedInfo.add(line); }
    public int getNumOfPeople() { return numOfPeople; }
    public int getHeightOfLadder(){ return heightOfLadder; }
    public int getMaxResultLength() { return MAX_RESULT_LENGTH; }
    public void swapPlayerResult(int i) { players.swapPlayersResult(i); }
    public Stream<Player> getPlayerStream() { return players.getPlayersStream(); }
    public Stream<Point> getConnectedStream(int row) { return connectedInfo.get(row).getLineStream(); }
    public Stream<String> getResultStream() { return results.stream(); }
}
