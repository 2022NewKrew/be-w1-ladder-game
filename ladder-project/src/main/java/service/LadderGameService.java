package service;

import domain.Result;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LadderGameService {

    private final LadderService ladderService;
    private final ParticipantService participantService;

    public LadderGameService(LadderService ladderService, ParticipantService participantService) {
        this.ladderService = ladderService;
        this.participantService = participantService;
    }

    public Map<String, String> playGame(Result result) {
        Map<String, String> gameResult = new HashMap<>();
        List<List<Boolean>> board = ladderService.createLadderForGame(participantService.getParticipantNumber());

        for (int i = 0; i < board.get(0).size(); i++) {
            ifIndexEvenExecute(result, gameResult, board, i);
        }

        return gameResult;
    }

    private void ifIndexEvenExecute(Result result, Map<String, String> gameResult, List<List<Boolean>> board, int i) {
        if (i % 2 == 0) {
            int position = search(board, 0, i, new boolean[board.size()][board.get(0).size()]);
            gameResult.put(participantService.getParticipantNameList().get(i / 2), result.getResult().get(position / 2));
        }
    }

    private int search(List<List<Boolean>> board, int r, int c, boolean[][] visited) {
        if (r == board.size() - 1) {
            return c;
        }

        int result;
        visited[r][c] = true;
        if (c + 1 < board.get(0).size() && !visited[r][c + 1] && board.get(r).get(c + 1)) {
            result = search(board, r, c + 1, visited);
        } else if (c - 1 >= 0 && !visited[r][c - 1] && board.get(r).get(c - 1)) {
            result = search(board, r, c - 1, visited);
        } else {
            result = search(board, r + 1, c, visited);
        }

        return result;
    }
}
