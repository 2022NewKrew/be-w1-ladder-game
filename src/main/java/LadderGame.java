import ladder.domain.Ladder;
import ladder.view.Input;
import ladder.view.Output;

public class LadderGame {
    public static void main(String[] args) {
        Ladder ld = new Ladder(Input.getPlayerNames(), Input.getResultNames(), Input.getLadderHeight());
        Output.printTotal(ld);
        boolean isLoop;
        do {
            isLoop = Output.printPlayerResult(ld, Input.getPlayerNameOfResult());
        } while (isLoop);
        Output.printEndGame();
    }
}
