package ladder.view;

import ladder.service.LadderService;
import ladder.view.dto.CommandDto;
import ladder.view.dto.LadderDto;

public class LadderController {

    public static void startGame() {
        LadderDto ladderDto = InputController.getConfigs();
        LadderService.runLadderGame(ladderDto);
    }

    public static void getCommand() {
        CommandDto commandDto = InputController.getCommand();

        if (commandDto.getCommand().equals("춘식이")) {
            System.out.println("게임을 종료합니다.");
            System.exit(0);
        }
        LadderService.runCommand(commandDto);

    }

}
