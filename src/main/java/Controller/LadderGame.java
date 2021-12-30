package Controller;

import domain.Ladder;
import domain.LadderGenerator;
import domain.PlayerRepository;
import view.InputView;
import view.OutputView;

public class LadderGame {

    public void run() {
        int playerNums = InputView.inputPlayersNum();
        PlayerRepository playerRepository = new PlayerRepository(InputView.inputPlayerNames());
        int maximumLadderHeight = InputView.inputMaximumLadderHeight();

        LadderGenerator ladderGenerator = new LadderGenerator();
        Ladder ladder = ladderGenerator.createLadder(playerNums, maximumLadderHeight);

        OutputView.printLadder(ladder);

    }
}
