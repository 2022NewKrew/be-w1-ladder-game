import dto.Ladder;
import input.CommandLineInputController;
import input.InputController;
import dto.LadderInfo;
import output.CommandLineOutputController;
import service.LadderGenerator;
import service.RandomLadderGenerator;

public class LadderGame {
    private final InputController inputController = new CommandLineInputController();
    private final LadderGenerator ladderGenerator = new RandomLadderGenerator();
    private final CommandLineOutputController commandLineOutputController = new CommandLineOutputController();

    public void start(){
        LadderInfo ladderInfo = inputController.createLadderInfo();
        Ladder ladder = ladderGenerator.buildLadder(ladderInfo.getHeights(), ladderInfo.getNumberOfParticipants());
        commandLineOutputController.printLadder(ladder);
    }
}
