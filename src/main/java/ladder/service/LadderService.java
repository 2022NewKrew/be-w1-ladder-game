package ladder.service;

import ladder.domain.Ladder;
import ladder.view.dto.LadderDto;

public class LadderService {

    private final Ladder ladder;

    public LadderService(Ladder ladder) {
        this.ladder = ladder;
    }

    public void runLadderGame(LadderDto ladderDto) {
        ladder.preprocessInput(ladderDto.getNameList(), ladderDto.getHeigth());
        ladder.makeLadder();
        ladder.printLadder();
    }

}
