package controller;

import domain.Ladder;
import domain.LadderGenerator;
import domain.PlayerRepository;
import service.LadderGameResult;
import service.LadderGameService;
import view.InputView;
import view.OutputView;

import java.util.List;

public class LadderGame {

    public void run() {
        PlayerRepository playerRepository = new PlayerRepository(InputView.inputPlayerNames());
        int playerNums = playerRepository.getPlayerNums();
        List<String> inputExecution = InputView.inputExecution();
        int maximumLadderHeight = InputView.inputMaximumLadderHeight();

        LadderGenerator ladderGenerator = new LadderGenerator(playerNums, maximumLadderHeight);
        Ladder ladder = ladderGenerator.createLadder();

        LadderGameResult ladderGameResult = LadderGameService.serviceStart(playerRepository, ladder);


        OutputView.printPlayers(playerRepository);
        OutputView.printLadder(ladder);
        OutputView.printResult(inputExecution);

    }
}
