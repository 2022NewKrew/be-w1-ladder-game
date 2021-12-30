package ladder;

import ladder.domain.LadderGame;
import ladder.view.LadderGameView;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        try {
            List<String> names = LadderGameView.inputParticipantNames();
            int ladderHeight = LadderGameView.inputLadderHeight();
            LadderGame game = LadderGame.createGame(names, ladderHeight);
            LadderGameView.printParticipantsAndLadder(game.getParticipants(), game.getLadder());
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return;
        }
    }

}
