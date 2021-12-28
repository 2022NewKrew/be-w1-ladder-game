package ladderGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ladder {
    private static final Random random = new Random();
    private final int numberOfPlayers;
    private final int height;
    private List<List<String>> ladder = null;

    Ladder(int[] args) {
        this.numberOfPlayers = args[0];
        this.height = args[1];

        if(ladder == null) ladder = new ArrayList(height);
        for(int i = 0; i < height; i++) {
            makeRow();
        }
    }

    private void makeRow() {
        List<String> temp = new ArrayList(numberOfPlayers - 1);
        for(int i = 0; i < numberOfPlayers - 1; i++) {
            temp.add(getBarRandomly()); // depth 줄이기 위해 method 분리
        }
        ladder.add(temp);
    }

    private String getBarRandomly() { return random.nextBoolean() ? "-" : " "; }

    public void print() {
        for(List<String> ladderRow : ladder) {
            printRow(ladderRow);
            System.out.println("|");
        }
    }

    private void printRow(List<String> ladderRow) {
        for(String bar : ladderRow) {
            System.out.print("|");
            System.out.print(bar);
        }
    }
}
