package step2;

import step2.domain.Ladder;
import step2.domain.RandomLadderGenerator;
import step2.dto.LadderConfig;
import step2.view.input.HeightAndPeopleInputInterface;
import step2.view.input.InputInterface;
import step2.view.output.LadderOutputInterface;
import step2.view.output.OutputInterface;

public class RandomLadderGame {
    private final InputInterface inputInterface = new HeightAndPeopleInputInterface();
    private final RandomLadderGenerator randomLadderGenerator = new RandomLadderGenerator();
    private final OutputInterface outputInterface = new LadderOutputInterface();

    public void start() {
        final LadderConfig ladderConfig = inputInterface.inputLadderConfig();
        final Ladder ladder = randomLadderGenerator.generate(ladderConfig);
        outputInterface.print(ladder);
    }
}
