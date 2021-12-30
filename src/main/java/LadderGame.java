import ladder.domain.Ladder;
import ladder.view.Input;
import ladder.view.Output;

public class LadderGame {
    public static void main(String[] args) {
        Ladder ld = new Ladder(Input.getPlayerNames(), Input.getLadderHeight());
        Output.printPlayerList(ld);
        Output.printLadder(ld);
    }
}
