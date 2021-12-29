import ladder.LadderGameService;
import ladder.view.InputView;

public class LadderGameApplication {

    public static void main(String[] args) {
        LadderGameService ladderGameService = new LadderGameService();
        InputView inputView = InputView.getInstance();

        ladderGameService.makePlayers(inputView.inputPlayersName());
        ladderGameService.makeLadder(inputView.inputLadderHeight());
        ladderGameService.makeStrategy("random");
        ladderGameService.drawBridgesByStrategy();

        ladderGameService.printLadderInfo();
    }
}
