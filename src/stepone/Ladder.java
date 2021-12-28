package stepone;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

class Ladder {
    final int ladderHeight, numPlayers;
    private List<String> ladderArray = new ArrayList<>();
    Random random = new Random();

    public Ladder(int ladderHeight, int numPlayers) {
        this.ladderHeight = ladderHeight;
        this.numPlayers = numPlayers;
        getLadder();
    }

    // gets each level of ladder
    private String getLevel() {
        StringBuilder sb = new StringBuilder();
        sb.append('|');
        for (int i = 0; i < numPlayers - 1; i += 1) {
            boolean isStep = random.nextBoolean();
            sb.append(isStep ? '-' : ' ');
            sb.append('|');
        }
        return sb.toString();
    }

    void getLadder() {
        for (int i = 0; i < ladderHeight; i++) {
            ladderArray.add(getLevel());
        }
    }

    void printLadder() {
        ladderArray.forEach(s -> System.out.println(s));
    }
}
