import service.domain.Ladder;
import input.CommandLineInputController;
import input.InputController;
import dto.LadderInputRawData;
import output.CommandLineOutputController;
import output.OutputController;
import service.domain.LadderGamePlay;
import service.domain.LadderGenerator;
import service.domain.RandomLadderGenerator;

import java.util.List;
import java.util.Map;

public class LadderGameMain {
    private final InputController inputController = new CommandLineInputController();
    private final LadderGenerator ladderGenerator = new RandomLadderGenerator();
    private final OutputController outputController = new CommandLineOutputController();

    public void start() {
        LadderInputRawData ladderInputRawData = inputController.inputLadderRawData();
        Ladder ladder = ladderGenerator.buildLadder(ladderInputRawData);
        LadderGamePlay ladderGamePlay = new LadderGamePlay();
        Map<String, Integer> playLadderGameResult = ladderGamePlay.playLadderGame(ladder);
        outputController.outputLadder(ladder);
        viewPlayLadderGameResult(playLadderGameResult, ladder.getGameResultsLine());
        inputController.close();
    }

    private void viewPlayLadderGameResult(Map<String, Integer> playLadderGameResult, List<String> gameResultsLine) {
        String name = inputController.inputNameForResult(playLadderGameResult.keySet());
        while (!name.equals("춘식이")){
            outputController.outputResult(playLadderGameResult, gameResultsLine, name);
            name = inputController.inputNameForResult(playLadderGameResult.keySet());
        }
        outputController.outputEndingComment();
    }
}
