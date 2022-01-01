package Controller;

import domain.Ladder;
import domain.LadderGenerator;
import domain.PlayerRepository;
import view.InputView;
import view.OutputView;

public class LadderGame {

    public void run() {
        PlayerRepository playerRepository = new PlayerRepository(InputView.inputPlayerNames());
        int playerNums = playerRepository.getPlayerNums();
        int maximumLadderHeight = InputView.inputMaximumLadderHeight();

        LadderGenerator ladderGenerator = new LadderGenerator(playerNums, maximumLadderHeight);
        Ladder ladder = ladderGenerator.createLadder();

        OutputView.printPlayers(playerRepository);
        OutputView.printLadder(ladder);

    }
}
