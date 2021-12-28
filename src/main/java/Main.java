import java.util.*;

public class Main {

    public static void main(String[] args) {
        int numberOfPlayer = Input.inputNumberOfPlayer();
        int height = Input.inputHeight();

        LadderBuilder ladderBuilder = new LadderBuilder(numberOfPlayer, height);
        Ladder ladder = ladderBuilder.makeLadder();
        Output.printLadder(ladder.getLadder());
    }
}
