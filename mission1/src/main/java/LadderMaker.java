import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class LadderMaker {
    private final int row;
    private final int nameLen;
    private final int numOfPlayer;
    private final int offset;
    private final ArrayList<Line> ladder;
    private final Random random;

    public LadderMaker(LadderInputManager ladderInputManager) {
        row = ladderInputManager.getMaxHeight();
        nameLen = ladderInputManager.getNameLen();
        offset = nameLen / 2;
        numOfPlayer = ladderInputManager.getNumOfPlayer();
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

    public int getNameLen() {
        return nameLen;
    }

    private void makeLadder(ArrayList ladder){
        for (int i=0; i<row; i++) {
            ladder.add(makeLine());
        }
    }

    private Line makeLine() {
        return new Line(numOfPlayer, random);
    }
}
