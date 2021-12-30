package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ladder {
    private final int numParticipant;
    private final int height;
    private List<List<Boolean>> connections;
    private List<Player> players;
    private Random random = new Random();

    public Ladder(int numParticipant, int height, List<Player> players) {
        this.numParticipant = numParticipant;
        this.height = height;
        this.players = players;
        createLadder();
    }

    public List<List<Boolean>> getConnections() {
        return connections;
    }

    public List<Player> getPlayers() {
        return players;
    }

    private void createLadder(){
        connections = new ArrayList<>();
        for(int i = 0; i < height; i++){
            connections.add(createRow());
        }
    }

    private List<Boolean> createRow(){
        List<Boolean> row = new ArrayList<>();
        for(int j = 0; j < numParticipant - 1; j++){
            row.add(createCell(row, j));
        }
        return row;
    }

    private Boolean createCell(List<Boolean> row, int colIndex){
        if(colIndex == 0 || Boolean.FALSE.equals(row.get(colIndex - 1))){
            return random.nextBoolean();
        }
        return Boolean.FALSE;
    }
}
