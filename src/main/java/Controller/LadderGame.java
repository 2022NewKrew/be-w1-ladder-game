package Controller;

import domain.Ladder;
import domain.LadderGenerator;
import view.InputView;
import view.OutputView;

public class LadderGame {

    public void run() {
        int playersNum = InputView.inputPlayersNum();
        int maximumLadderHeight = InputView.inputMaximumLadderHeight();

        LadderGenerator ladderGenerator = new LadderGenerator();
        Ladder ladder = ladderGenerator.createLadder(playersNum, maximumLadderHeight);

        OutputView.printLadder(ladder);

    }
}
