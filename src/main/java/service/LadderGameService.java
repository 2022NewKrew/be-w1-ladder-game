package service;

import dao.GameResultDAO;
import dto.ladderDto.LadderDTO;
import dto.gameResultDto.AllResultDTO;
import dto.gameResultDto.TargetResultDTO;

import java.util.ArrayList;
import java.util.List;

public class LadderGameService {
    private final List<String> users;
    private final List<String> results;
    private final GameResultDAO gameResultDAO = new GameResultDAO();

    public LadderGameService(List<String> users, List<String> results) {
        this.users = new ArrayList<>(users);
        this.results = results;
    }

    public void calculateGameResult(LadderDTO ladderDTO) {
        gameResultDAO.saveGameResult(ladderDTO, users, results);
    }

    public TargetResultDTO getTargetResult(String target) {
        return gameResultDAO.getTargetResultDto(target);
    }

    public AllResultDTO getAllResult() {
        return gameResultDAO.getAllResultDto();
    }

}
