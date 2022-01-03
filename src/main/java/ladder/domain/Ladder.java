package ladder.domain;

import java.util.List;
import java.util.ArrayList;

final class LadderConstants {
    static final int maxNameLength = 5;

    private LadderConstants() {}
}

public class Ladder {
    final int ladderHeight, numPlayers;
    final int maxNameLength = LadderConstants.maxNameLength;
    private final List<String> ladderArray = new ArrayList<>();
    private final List<String> players;

    public Ladder(int ladderHeight, int numPlayers) {
        this.ladderHeight = ladderHeight;
        this.numPlayers = numPlayers;
        this.players = new ArrayList<>();
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

    public void printLadder() {
        players.forEach(s->System.out.print(" ".repeat((maxNameLength+1-Math.min(5, s.length()))/2) + String.format("%.5s", s) + " ".repeat((maxNameLength+2-Math.min(5, s.length()))/2)));
        System.out.println();
        ladderArray.forEach(s -> System.out.println("  " + s));
    }
}