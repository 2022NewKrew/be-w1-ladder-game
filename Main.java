package main;
import main.domain.LadderGame;
import main.domain.LadderGameInput;
import main.view.UI;

public class Main {
    public static void main(String[] args) {
        LadderGameInput userInput = UI.getLadderGameInfo();
        String[] names = userInput.getNames();
        int heightOfLadder = userInput.getHeightOfLadder();
        LadderGame ladderGame = new LadderGame(names, heightOfLadder);
        UI.printLadder(ladderGame);
    }
}
