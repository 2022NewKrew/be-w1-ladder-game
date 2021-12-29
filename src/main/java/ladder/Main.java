package ladder;

import ladder.view.LadderGame;

public class Main {

    public static void main(String[] args) {
        LadderGame game = new LadderGame();
        try {
            game.start();
            game.printParticipantsAndLadder();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

}
