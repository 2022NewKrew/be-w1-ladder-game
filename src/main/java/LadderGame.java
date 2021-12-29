import java.util.ArrayList;

public class LadderGame {

    UserInterface userInterface;
    LadderService ladderService;
    PlayerService playerService;

    private LadderGame() {
        this.userInterface = new UserInterface();
        this.ladderService = new LadderService();
        this.playerService = new PlayerService();
    }

    public static void main(String[] args) {
        LadderGame ladderGame = new LadderGame();
        ladderGame.initData();
        ladderGame.printData();
    }

    private void initData() {
        Input<ArrayList<String>> playersInput = userInterface.readPlayers();
        Input<Integer> heightInput = userInterface.readHeight();
        ladderService.makeLadder(heightInput.getValue(), playersInput.getValue().size());
        playerService.makePlayerList(playersInput);
    }

    private void printData() {
        userInterface.printPlayers(playerService.getPlayerList());
        userInterface.printLadder(ladderService.getLadder());
    }


}
