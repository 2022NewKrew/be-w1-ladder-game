package ladder;

import ladder.view.LadderStepThree;
import ladder.domain.Ladder;

import java.util.List;


public class LadderMain {

    public static void main(String[] args) {
        LadderStepThree ladderGame = new LadderStepThree();
        List<String> players = ladderGame.getPlayers();
        int ladderHeight = ladderGame.getLadderHeight();

        Ladder ladder = new Ladder(ladderHeight, players);
        ladder.printLadder();
    }
}
