package Controller;

import domain.Ladder;
import domain.LadderGenerator;
import domain.PlayerRepository;
import view.InputView;
import view.OutputView;

public class LadderGame {

    public void run() {
        PlayerRepository playerRepository = new PlayerRepository(InputView.inputPlayerNames());
        int playerNums = playerRepository.getPlayers().size();
        int maximumLadderHeight = InputView.inputMaximumLadderHeight();

        LadderGenerator ladderGenerator = new LadderGenerator();
        Ladder ladder = ladderGenerator.createLadder(playerNums, maximumLadderHeight);

        OutputView.printPlayers(playerRepository);
        OutputView.printLadder(ladder);

    }
}
