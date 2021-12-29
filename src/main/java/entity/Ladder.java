package entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ladder {
    private final int numParticipant;
    private final int height;
    private List<ArrayList<Boolean>> ladder;
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

    private void createLadder(){
        ladder = new ArrayList<>();
        Random random = new Random();
        for(int i = 0; i < height; i++){
            ladder.add(createRow(random));
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

    public void draw(){
        players.forEach(player -> {
            System.out.printf("%5s ", player.getName());
        });
        System.out.println();
        ladder.forEach(row -> {
            System.out.print("  │");
            row.forEach(item -> System.out.print(item ? "-----│" : "     │"));
            System.out.println();
        });
    }
}
