package dao;

import domain.ladder.Ladder;
import dto.ladderDto.LadderDTO;

public class LadderDAO {

    private Ladder ladder;

    public LadderDAO() {

    }

    public void saveLadder(int frameLength, int height) {
        ladder = new Ladder(frameLength, height);
    }

    public LadderDTO getLadderDTO() {
        return new LadderDTO(ladder);
    }
}
