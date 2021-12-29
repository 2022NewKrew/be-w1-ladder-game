import dto.Ladder;
import input.CommandLineInputController;
import input.InputController;
import dto.LadderInputInfo;
import output.CommandLineOutputController;
import output.OutputController;
import preproces.InputPreprocessor;
import preproces.NameInputPreprocessor;
import service.LadderGenerator;
import service.RandomLadderGenerator;

public class LadderGame {
    private final InputController inputController = new CommandLineInputController();
    private final InputPreprocessor inputPreProcessor = new NameInputPreprocessor();
    private final LadderGenerator ladderGenerator = new RandomLadderGenerator();
    private final OutputController commandLineOutputController = new CommandLineOutputController();

    public void start() {
        LadderInputInfo ladderInputInfo = inputController.inputLadderInfo();
        inputPreProcessor.inputPreProcessing(ladderInputInfo);
        Ladder ladder = ladderGenerator.buildLadder(ladderInputInfo);
        commandLineOutputController.outputLadder(ladder);
    }
}
