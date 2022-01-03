package service;

import dao.GameResultDAO;
import dao.LadderDAO;
import domain.ladder.Ladder;
import dto.gameResultDto.AllResultDTO;
import dto.gameResultDto.TargetResultDTO;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class GameResultService {
    private final GameResultDAO gameResultDAO = GameResultDAO.getInstance();
    private final LadderDAO ladderDAO = LadderDAO.getInstance();

    public void calculateGameResult(List<String> users, List<String> results) {
        Ladder ladder = ladderDAO.getLadder();
        gameResultDAO.saveGameResult(ladder.getBridgeIndexes(), users, results);
    }

    public TargetResultDTO getTargetResult(String target) {
        return new TargetResultDTO(targetResult(target));
    }

    public AllResultDTO getAllResult() {
        return new AllResultDTO(allResult());
    }

    private String targetResult(String target) {
        return gameResultDAO.getGameResult().getResult().get(target);
    }

    private Set<Map.Entry<String, String>> allResult() {
        return gameResultDAO.getGameResult().getResult().entrySet();
    }

}
