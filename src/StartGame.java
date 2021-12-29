public class StartGame {

    public static void main(String[] args) {
        LadderGame ladderGame = new LadderGame();
        ladderGame.makeLadder();
        GameView gameView = new GameView(ladderGame);
        gameView.showParticipants();
        gameView.showLadder();
    }

}
