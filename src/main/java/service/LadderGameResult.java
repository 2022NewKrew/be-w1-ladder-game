package service;

import domain.*;

import java.util.*;

public class LadderGameResult {
    private final Map<String, Integer> result;

    public LadderGameResult(PlayerRepository playerRepository, Ladder ladder, List<String> inputExecution) {
        this.result = createLadderGameResult(playerRepository, ladder, inputExecution);
    }

    public Map<String, Integer> getResult() {
        return Collections.unmodifiableMap(result);
    }

    private Map<String, Integer> createLadderGameResult(PlayerRepository playerRepository, Ladder ladder, List<String> inputExecution) {
        Map<String, Integer> createdResult = new HashMap<>();
        List<Player> players = playerRepository.getPlayers();
        for (int playerIndex = 0; playerIndex < players.size(); playerIndex++) {
            createdResult.put(players.get(playerIndex).getName(), playerStartGame(playerIndex, ladder));
        }
        return createdResult;
    }

    private int playerStartGame(int playerResultIndex, Ladder ladder) {
        int changedResultIndex = checkHorizontalRight(playerResultIndex, ladder.getLadder().get(0));
        for (int i = 1; i < ladder.getLadder().size(); i++) {
            changedResultIndex = checkHorizontalRight(changedResultIndex, ladder.getLadder().get(i));
        }
        return changedResultIndex;
    }

    private int checkHorizontalRight(int playerResultIndex, LadderLine ladderLine) {
        if (ladderLine.getLadderLinePieces().get(playerResultIndex).getPiece()) {
            return ++playerResultIndex;
        } return checkHorizontalLeft(playerResultIndex, ladderLine);
    }

    private int checkHorizontalLeft(int playerResultIndex, LadderLine ladderLine) {
        if ((playerResultIndex > 0) && (ladderLine.getLadderLinePieces().get(playerResultIndex-1).getPiece())) {
            return --playerResultIndex;
        } return playerResultIndex;
    }
}
