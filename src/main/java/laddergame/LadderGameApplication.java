package laddergame;

public class LadderGameApplication {

    public static void main(String[] args) {
        try {
            LadderGame ladderGame = new LadderGame();
            ladderGame.readUserName();
            Integer userCount = ladderGame.getUserCount();
            Integer ladderCount = ladderGame.readLadderCount();
            ladderGame.makeLadder(userCount, ladderCount);

            ladderGame.printLadderBoard();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
