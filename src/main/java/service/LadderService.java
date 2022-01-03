package service;

import domain.ladder.Ladder;
import dto.ladderDto.LadderDTO;

public class LadderService {
    private Ladder ladder;

    public LadderDTO getLadderDto() {
        return new LadderDTO(ladder);
    }

    public void generateLadder(int frameLength, int ladderHeight) {
        Ladder.makeLadder(frameLength, ladderHeight);
        ladder = Ladder.getInstance();
    }
}
