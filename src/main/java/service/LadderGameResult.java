package service;

import domain.*;

import java.util.*;

public class LadderGameResult {
    private final Map<String, Integer> result;

    public LadderGameResult(PlayerRepository playerRepository, Ladder ladder, List<String> inputExecution) {
        this.result = new HashMap<>();
        createLadderGameResult(playerRepository, ladder, inputExecution);
    }

    private Map<String, String> createLadderGameResult(PlayerRepository playerRepository, Ladder ladder, List<String> inputExecution) {
        Map<String, String> createdResult = new HashMap<>();
        List<Player> players = playerRepository.getPlayers();
        System.out.println("input 전" + inputExecution);
        List<String> resultValues = checkSwap(ladder, inputExecution);
        System.out.println("resulvaues" + resultValues);
        int i = 0;
        for (Player player : players) {

            System.out.println(i);
            createdResult.put(player.getName(), resultValues.get(i));
            i++;
        }
        System.out.println("createdresult" + createdResult);
        return createdResult;
    }

    private List<String> checkSwap(Ladder ladder, List<String> inputExecution) {
        List<String> copiedInputExecution = new ArrayList<>(inputExecution.size());
        copiedInputExecution.addAll(inputExecution);
        System.out.println(ladder.getLadder());
        System.out.println(ladder.getLadder().get(0));
        System.out.println(ladder.getLadder().get(1));
        for (LadderLine ladderLine : ladder.getLadder()) {
            System.out.println(ladderLine.getLadderLinePieces());
            int cnt = 0;
            for (Piece piece : ladderLine.getLadderLinePieces()) {
                System.out.println(piece.getPiece());
                if (piece.getPiece()) {
                    System.out.println("swap 전 " + cnt + copiedInputExecution);
                    Collections.swap(copiedInputExecution, cnt, cnt + 1);
                    System.out.println("swap 후 " + cnt + copiedInputExecution);
                }
                cnt += 1;
            }
        }
        return copiedInputExecution;
    }
}
