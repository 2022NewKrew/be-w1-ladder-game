package ladder.domain;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

final class LadderConstants {
    static final int maxNameLength = 5;

    private LadderConstants() {}
}

public class Ladder {
    final int ladderHeight, numPlayers;
    final int maxNameLength = LadderConstants.maxNameLength;
    private final List<String> ladderArray = new ArrayList<>();
    private final List<String> players;
    private final List<String> ladderResult;
    private final Map<String, String> gameResult = new HashMap<>();

    public Ladder(int ladderHeight, List<String> players) {
        this.ladderHeight = ladderHeight;
        this.numPlayers = players.size();
        this.players = players;
        this.ladderResult = new ArrayList<>();
        getLadder();
    }

    public Ladder(int ladderHeight, List<String> players, List<String> ladderResult) {
        this.ladderHeight = ladderHeight;
        this.numPlayers = players.size();
        this.players = players;
        this.ladderResult = ladderResult;
        getLadder();
        printLadder();
        getGameResult();
    }

    void getLadder() {
        for (int i = 0; i < ladderHeight; i++) {
            Level level = new Level(numPlayers);
            ladderArray.add(level.toString());
        }
    }

    private int shiftLeft(String row, int x) {
        while (x>0 && row.charAt(6*x-1)=='-') {
            x--;
        }
        return x;
    }

    private int shiftRight(String row, int x) {
        while (x<numPlayers-1 && row.charAt(6*x+1)=='-') {
            x++;
        }
        return x;
    }

    private int shiftLeftRight(String row, int x) {
        int shiftedX = shiftLeft(row, x);
        if (shiftedX == x) {
            return shiftRight(row, x);
        }
        return shiftedX;
    }

    private int moveHorizontal(int x, int y) {
        String row = ladderArray.get(y);
        if (0<x && x <numPlayers-1) {
            return shiftLeftRight(row, x);
        }
        if (x==0) {
            return shiftRight(row, x);
        }
        return shiftLeft(row, x);
    }

    private int moveIndex(int x) {
        int y = 0;
        while (y<ladderHeight) {
            x = moveHorizontal(x, y);
            y++;
        }
        return x;
    }

    private void getGameResult() {
        for (int i=0; i<players.size(); i++) {
            int finalIndex = moveIndex(i);
            gameResult.put(players.get(i), ladderResult.get(finalIndex));
        }
    }

    private void printLadder() {
        System.out.println("사다리 결과");
        players.forEach(s->System.out.print(" ".repeat((maxNameLength+1-Math.min(5, s.length()))/2) + String.format("%.5s", s) + " ".repeat((maxNameLength+2-Math.min(5, s.length()))/2)));
        System.out.println();
        ladderArray.forEach(s -> System.out.println("  " + s));
        ladderResult.forEach(s->System.out.print(" ".repeat((maxNameLength+1-Math.min(5, s.length()))/2) + String.format("%.5s", s) + " ".repeat((maxNameLength+2-Math.min(5, s.length()))/2)));
        System.out.println();
    }

    public void queryResult(String playerName) {
        System.out.println("실행 결과");
        if (playerName.equals("all")) {
            gameResult.forEach((key, value)-> System.out.println(key+" : "+value));
            return;
        }
        System.out.println(gameResult.get(playerName));
    }
}