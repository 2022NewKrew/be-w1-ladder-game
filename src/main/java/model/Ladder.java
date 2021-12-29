package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ladder {
    private final int numParticipant;
    private final int height;
    private List<ArrayList<Boolean>> connections;
    private ArrayList<Player> players;

    public Ladder(int numParticipant, int height, ArrayList<Player> players) {
        this.numParticipant = numParticipant;
        this.height = height;
        this.players = players;
        createLadder();
    }

    public int getNumParticipant() {
        return numParticipant;
    }

    public List<ArrayList<Boolean>> getConnections() {
        return connections;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    private void createLadder(){
        connections = new ArrayList<>();
        Random random = new Random();
        for(int i = 0; i < height; i++){
            connections.add(createRow(random));
        }
    }

    private ArrayList<Boolean> createRow(Random random){
        ArrayList<Boolean> row = new ArrayList<>();
        for(int j = 0; j < numParticipant - 1; j++){
            row.add(createCell(random, row, j));
        }
        return row;
    }

    private Boolean createCell(Random random, ArrayList<Boolean> row, int colIndex){
        if(colIndex == 0 || Boolean.FALSE.equals(row.get(colIndex - 1))){
            return random.nextBoolean();
        }
        return Boolean.FALSE;
    }
}
