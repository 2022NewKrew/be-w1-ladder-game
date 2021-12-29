package ladder.service;

import ladder.domain.Ladder;
import ladder.view.dto.LadderDto;

public class LadderService {

    public static void runLadderGame(LadderDto ladderDto) {
        Ladder.preprocessInput(ladderDto.getNameList(), ladderDto.getHeigth());
        Ladder.makeLadder();
        Ladder.printLadder();
    }

}
