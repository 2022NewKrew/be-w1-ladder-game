package stepone;

import java.util.List;
import java.util.ArrayList;

class Ladder {
    final int ladderHeight, numPlayers;
    final int maxNameLength = 5;
    private final List<String> ladderArray = new ArrayList<>();
    private List<String> players = new ArrayList<>();

    public Ladder(int ladderHeight, int numPlayers) {
        this.ladderHeight = ladderHeight;
        this.numPlayers = numPlayers;
        getLadder();
    }

    public Ladder(int ladderHeight, List<String> players) {
        this.ladderHeight = ladderHeight;
        this.numPlayers = players.size();
        this.players = players;
        getLadder();
    }

    void getLadder() {
        for (int i = 0; i < ladderHeight; i++) {
            Level level = new Level(numPlayers);
            ladderArray.add(level.toString());
        }
    }

    void printLadder() {
        players.forEach(s->System.out.print(" ".repeat((maxNameLength+1-s.length())/2) + String.format("%.5s", s) + " ".repeat((maxNameLength+2-s.length())/2)));
        System.out.println();
        ladderArray.forEach(s -> System.out.println("  " + s));
    }
}
