package ladder;

import ladder.view.LadderInput;
import ladder.domain.Ladder;

import java.util.List;


public class LadderMain {

    public static void main(String[] args) {

        List<String> players = LadderInput.getPlayers();
        int ladderHeight = LadderInput.getLadderHeight();

        Ladder ladder = new Ladder(ladderHeight, players);
        ladder.printLadder();
    }
}
