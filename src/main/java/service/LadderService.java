package service;

import dao.LadderDAO;
import dto.ladderDto.LadderDTO;

public class LadderService {
    private final LadderDAO ladderDAO;

    public LadderService(int frameLength, int ladderHeight) {
        ladderDAO = new LadderDAO(frameLength, ladderHeight);
    }

    public LadderDTO getLadderDto() {
        return ladderDAO.getLadderDTO();
    }
}
