import domain.LadderGame;
import view.GameView;

public class StartGame {

    public static void main(String[] args) {
        LadderGame ladderGame = new LadderGame(true);
        ladderGame.makeLadder();
        ladderGame.executeGame();
        GameView gameView = new GameView(ladderGame);
        gameView.showParticipants();
        gameView.showLadder();
        gameView.showResults();
        gameView.resultLoop();
    }

}
