package dao;

import domain.gameResult.GameResult;
import dto.ladderDto.LadderDTO;
import dto.gameResultDto.AllResultDTO;
import dto.gameResultDto.TargetResultDTO;

import java.util.ArrayList;
import java.util.List;

public class GameResultDAO {
    public GameResult gameResult;

    public void saveGameResult(LadderDTO ladderDTO, List<String> users, List<String> results) {
        gameResult = new GameResult(ladderDTO, users, results);
    }

    public AllResultDTO getAllResultDto() {
        return new AllResultDTO(new ArrayList<>(gameResult.getResult().entrySet()));
    }

    public TargetResultDTO getTargetResultDto(String target) {
        return new TargetResultDTO(gameResult.getResult().get(target));
    }
}
