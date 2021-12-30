package main.java.ladder.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static main.java.ladder.domain.LadderComponent.*;

public class LadderGame {
    private final Ladder ladder;
    private final Map<String, String> playerResult;

    public LadderGame(Ladder ladder, List<String> players, List<String> results) {
        this.ladder = ladder;
        this.playerResult = new HashMap<>();
        players.forEach(player ->
                playerResult.put(player, playGame(startIdx(players.indexOf(player)), results)));
    }

    private String playGame(int startCol, List<String> results) {
        int curCol = startCol;
        for (int i = 0; i < ladder.getHeightOfLadder(); i++) {
            curCol = nextCol(i, curCol);
        }
        return results.get(endIdx(curCol));
    }

    private int nextCol(int row, int col) {
        if (ladder.getLadderComponent(row, col - 1) == HORIZONTAL) {
            return col - 2;
        }
        if (ladder.getLadderComponent(row, col + 1) == HORIZONTAL) {
            return col + 2;
        }
        return col;
    }

    private int startIdx(int idx) {
        return idx * 2 + 1;
    }

    private int endIdx(int idx) {
        return (idx - 1) / 2;
    }

    public String getOnePlayerResult(String player) {
        return playerResult.get(player);
    }
}
