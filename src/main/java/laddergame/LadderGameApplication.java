package laddergame;

public class LadderGameApplication {

    public static void main(String[] args) {

        LadderGame ladderGame = new LadderGame();
        Integer userCount = ladderGame.readUserCount();
        Integer ladderCount = ladderGame.readLadderCount();
        ladderGame.makeLadder(userCount, ladderCount);

        ladderGame.printLadder(ladderCount);
    }

}
