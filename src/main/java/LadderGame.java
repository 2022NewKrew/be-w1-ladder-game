import Domain.*;
import View.Input;
import View.UserInterface;

import java.util.ArrayList;
import java.util.List;

public class LadderGame {

    private final UserInterface userInterface;
    private final LadderService ladderService;
    private final PlayerService playerService;
    private final ResultService resultService;
    private final CalculateService calculateService;

    private LadderGame() {
        this.userInterface = new UserInterface();
        this.ladderService = new LadderService();
        this.playerService = new PlayerService();
        this.resultService = new ResultService();
        this.calculateService = new CalculateService(ladderService, playerService, resultService);
    }

    public static void main(String[] args) {
        LadderGame ladderGame = new LadderGame();
        ladderGame.initData();
        ladderGame.printData();
        ladderGame.loopQuery();
    }

    private void initData() {
        List<String> playersInput = userInterface.readPlayers();
        List<String> resultInput = userInterface.readResult(playersInput.size());
        int heightInput = userInterface.readHeight();
        ladderService.makeLadder(heightInput, playersInput.size());
        playerService.makePlayerList(playersInput);
        resultService.makeResultList(resultInput, playersInput.size());


    }

    private void printData() {
        userInterface.printPlayers(playerService.getPlayerList());
        userInterface.printLadder(ladderService.getLadder());
        userInterface.printResults(resultService.getResultList());
    }

    private boolean readQuery() {
        List<String> queryPlayers = userInterface.readQuery();
        String cmd = queryPlayers.get(0);
        if (userInterface.isEnd(cmd)) {
            userInterface.printBye();
            return false;
        }
        if (userInterface.isAll(cmd)) {
            ResultList resultList = calculateService.calculateAllPlayerResult();
            PlayerList playerList = playerService.getPlayerList();
            userInterface.printAllPlayerAndResult(playerList, resultList);
            return true;
        }
        userInterface.printResultForQuery(calculateService.calculatePlayerResult(queryPlayers));
        return true;
    }

    public void loopQuery() {
        while (readQuery()) ;
    }

}
