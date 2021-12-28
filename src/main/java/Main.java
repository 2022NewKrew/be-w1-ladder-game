import java.util.*;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> names = Input.inputName();
        int height = Input.inputHeight();

        LadderBuilder ladderBuilder = new LadderBuilder(names.size(), height);
        Ladder ladder = ladderBuilder.makeLadder();
        Output.printName(names);
        Output.printLadder(ladder.getLadder());
    }
}
