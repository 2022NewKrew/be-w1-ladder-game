package ladder.service;

import ladder.domain.Ladder;
import ladder.view.dto.CommandDto;
import ladder.view.dto.LadderDto;

public class LadderService {

    public static void runLadderGame(LadderDto ladderDto) {
        Ladder.preprocessInput(ladderDto.getNameList(), ladderDto.getHeight(), ladderDto.getResultList());
        Ladder.makeLadder();
        Ladder.printLadder();
    }

    public static void runCommand(CommandDto commandDto) {
        Ladder.processCommand(commandDto.getCommand());
    }

}
