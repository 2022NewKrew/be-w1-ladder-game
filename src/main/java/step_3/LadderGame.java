package step_3;

import step_3.domain.Ladder;
import step_3.domain.LadderBuilder;
import step_3.dto.LadderInfo;
import step_3.view.input.InputInterface;
import step_3.view.input.NameAndHeightInputInterface;
import step_3.view.output.OutputInterface;
import step_3.view.output.LadderAndNameOutputInterface;

public class LadderGame {
    private final InputInterface inputInterface = new NameAndHeightInputInterface();
    private final OutputInterface outputInterface = new LadderAndNameOutputInterface();

    private final LadderBuilder ladderBuilder = new LadderBuilder();

    public void start() throws Exception {
        LadderInfo ladderInfo = inputInterface.inputArguments();
        Ladder ladder = ladderBuilder.build(ladderInfo);
        outputInterface.print(ladderInfo, ladder);
    }
}
