package service;

import dao.LadderDAO;
import dto.ladderDto.LadderDTO;

public class LadderService {
    private final LadderDAO ladderDAO;

    public LadderService() {
        ladderDAO = new LadderDAO();
    }

    public LadderDTO getLadderDto() {
        return ladderDAO.getLadderDTO();
    }

    public void generateLadder(int frameLength, int ladderHeight) {
        ladderDAO.saveLadder(frameLength, ladderHeight);
    }
}
