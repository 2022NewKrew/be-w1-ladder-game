package domain;

import dto.LadderInfo;
import view.input.InputInterface;
import view.input.NameAndResultInputInterface;
import view.output.LadderAndResultOutputInterface;
import view.output.OutputInterface;

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
