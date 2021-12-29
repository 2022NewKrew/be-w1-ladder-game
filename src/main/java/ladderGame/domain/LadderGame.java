package ladderGame.domain;

import ladderGame.domain.ladder.Ladder;
import ladderGame.domain.ladder.LadderGenerator;
import ladderGame.domain.ladderConfig.LadderConfig;
import ladderGame.exception.ExceptionHandler;
import ladderGame.exception.ladderException.LadderGameException;
import ladderGame.view.input.InputInterface;
import ladderGame.view.output.OutputInterface;

import java.util.List;

public class LadderGame {
    private final InputInterface inputInterface;
    private final LadderGenerator ladderGenerator;
    private final List<OutputInterface> outputInterfaceList;

    protected LadderGame(InputInterface inputInterface, LadderGenerator ladderGenerator, List<OutputInterface> outputInterfaceList) {
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
