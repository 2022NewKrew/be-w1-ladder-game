import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class LadderMaker {
    private final int row;
    private final int numOfPlayer;
    private final int offset;
    private final ArrayList<Line> ladder;
    private final Random random;

    public LadderMaker(LadderInputManager ladderInputManager, int nameLen) {
        row = ladderInputManager.getMaxHeight();
        offset = nameLen / 2;
        numOfPlayer = ladderInputManager.getPlayerList().size();
        ladder = new ArrayList<>();
        random = new Random();
        makeLadder(ladder);
    }

    public ArrayList<Line> getLadder() {
        return ladder;
    }

    public int getOffset() {
        return offset;
    }

    private void makeLadder(ArrayList<Line> ladder){
        for (int i=0; i<row; i++) {
            ladder.add(makeLine());
        }
    }

    private Line makeLine() {
        return new Line(numOfPlayer, random);
    }
}
