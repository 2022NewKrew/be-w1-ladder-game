package laddergame;

public class LadderGameApplication {

    public static void main(String[] args) {

        LadderGame ladderGame = new LadderGame();
        Integer userCount = ladderGame.readUserCount();
        Integer ladderCount = ladderGame.readLadderCount();

        Ladder ladder = new Ladder();
        ladder.makeLadder(userCount, ladderCount);
        ladderGame.setLadder(ladder);

        ladderGame.printLadder(ladderCount);
    }

}
