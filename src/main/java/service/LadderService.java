package service;

import dao.LadderDAO;
import dto.ladderDto.LadderDTO;

public class LadderService {
    private final LadderDAO ladderDAO = LadderDAO.getInstance();

    public LadderDTO getLadderDto() {
        return new LadderDTO(ladderDAO.getLadder());
    }

    public void generateLadder(int frameLength, int ladderHeight) {
        ladderDAO.saveLadder(frameLength, ladderHeight);
    }
}
