package step_4.domain;

import step_4.domain.Ladder;
import step_4.domain.LadderBuilder;
import step_4.dto.LadderInfo;
import step_4.view.input.InputInterface;
import step_4.view.input.NameAndHeightInputInterface;
import step_4.view.output.LadderAndNameOutputInterface;
import step_4.view.output.OutputInterface;

public class LadderGame {
    private final InputInterface inputInterface = new NameAndHeightInputInterface();
    private final OutputInterface outputInterface = new LadderAndNameOutputInterface();

    private final LadderBuilder ladderBuilder = new LadderBuilder();

    public void start() {
        LadderInfo ladderInfo = inputInterface.inputArguments();
        Ladder ladder = ladderBuilder.build(ladderInfo);
        outputInterface.print(ladderInfo, ladder);
    }
}
