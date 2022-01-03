package service;

import dao.GameResultDAO;
import dto.gameResultDto.AllResultDTO;
import dto.gameResultDto.TargetResultDTO;
import dto.ladderDto.LadderDTO;

import java.util.List;

public class GameResultService {
    private final GameResultDAO gameResultDAO = new GameResultDAO();

    public GameResultService() {
    }

    public void calculateGameResult(LadderDTO ladderDTO, List<String> users, List<String> results) {
        gameResultDAO.saveGameResult(ladderDTO, users, results);
    }

    public TargetResultDTO getTargetResult(String target) {
        return gameResultDAO.getTargetResultDto(target);
    }

    public AllResultDTO getAllResult() {
        return gameResultDAO.getAllResultDto();
    }

}
