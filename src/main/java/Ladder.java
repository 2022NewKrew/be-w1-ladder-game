import java.util.ArrayList;
import java.util.Random;

public class Ladder {
    private final int numPeople;
    private final int maxHeight;
    private final ArrayList<Line> ladder;
    private static final Random rand = new Random();

    public Ladder(int numPeople, int maxHeight){
        this.numPeople = numPeople;
        this.maxHeight  = maxHeight;
        ladder = new ArrayList<Line>();

        makeLadder();
    }

    private void makeLadder() {
        for (int i = 0; i < maxHeight; i++) {
           ladder.add(new Line(numPeople));
        }
    }

    public ArrayList<Line> getLadder() {
        return ladder;
    }
}

