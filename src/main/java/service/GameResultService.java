package service;

import domain.gameResult.GameResult;
import domain.ladder.Ladder;
import dto.gameResultDto.AllResultDTO;
import dto.gameResultDto.TargetResultDTO;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class GameResultService {
    private GameResult gameResult;
    private Ladder ladder;

    public void calculateGameResult(List<String> users, List<String> results) {
        ladder = Ladder.getInstance();
        GameResult.makeGameResult(ladder.getBridgeIndexes(), users, results);
        gameResult = GameResult.getInstance();
    }

    public TargetResultDTO getTargetResult(String target) {
        return new TargetResultDTO(targetResult(target));
    }

    public AllResultDTO getAllResult() {
        return new AllResultDTO(allResult());
    }

    private String targetResult(String target) {
        return gameResult.getResult().get(target);
    }

    private Set<Map.Entry<String, String>> allResult() {
        return gameResult.getResult().entrySet();
    }

}
