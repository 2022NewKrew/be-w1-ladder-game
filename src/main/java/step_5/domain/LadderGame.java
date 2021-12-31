package step_5.domain;

import step_5.dto.LadderInfo;
import step_5.view.input.InputInterface;
import step_5.view.input.NameAndHeightInputInterface;
import step_5.view.input.NameAndResultInputInterface;
import step_5.view.output.LadderAndNameOutputInterface;
import step_5.view.output.LadderAndResultOutputInterface;
import step_5.view.output.OutputInterface;

public class LadderGame {
    private final InputInterface inputInterface = new NameAndResultInputInterface();
    private final OutputInterface outputInterface = new LadderAndResultOutputInterface();

    private final LadderBuilder ladderBuilder = new LadderBuilder();

    public void start() {
        LadderInfo ladderInfo = inputInterface.inputArguments();
        Ladder ladder = ladderBuilder.build(ladderInfo);
        outputInterface.print(ladderInfo, ladder);
    }
}
