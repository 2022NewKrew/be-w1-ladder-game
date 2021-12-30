package step2LadderGame;

import step2LadderGame.domain.ladder.Ladder;
import step2LadderGame.domain.ladder.LadderGenerator;
import step2LadderGame.domain.ladder.RandomLadderGenerator;
import step2LadderGame.domain.ladderConfig.LadderConfig;
import step2LadderGame.exception.ExceptionHandler;
import step2LadderGame.exception.ladderException.LadderGameException;
import step2LadderGame.view.input.HeightAndNumOfParticipantsInputInterface;
import step2LadderGame.view.input.InputInterface;
import step2LadderGame.view.output.LadderOutputInterface;
import step2LadderGame.view.output.OutputInterface;

import java.util.List;

public class Step2LadderGame {
    private final InputInterface inputInterface;
    private final LadderGenerator ladderGenerator;
    private final List<OutputInterface> outputInterfaceList;

    public Step2LadderGame() {
        this.inputInterface = new HeightAndNumOfParticipantsInputInterface();
        this.ladderGenerator = new RandomLadderGenerator();
        this.outputInterfaceList = List.of(new LadderOutputInterface());
    }

    protected Step2LadderGame(InputInterface inputInterface, LadderGenerator ladderGenerator, List<OutputInterface> outputInterfaceList) {
        this.inputInterface = inputInterface;
        this.ladderGenerator = ladderGenerator;
        this.outputInterfaceList = outputInterfaceList;
    }

    public void start() {
        try {
            final LadderConfig ladderConfig = inputInterface.inputLadderConfig();
            final Ladder ladder = ladderGenerator.generate(ladderConfig);
            outputInterfaceList.forEach(outputInterface -> outputInterface.print(ladder));
        } catch (LadderGameException e) {
            ExceptionHandler.handle(e);
        }
    }
}
