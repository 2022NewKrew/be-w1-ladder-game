import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ladder {
    private final List<Line> ladder;
    private static final Random rand = new Random();

    public Ladder(int numPeople, int maxHeight){
        ladder = new ArrayList<Line>();
        makeLadder(numPeople, maxHeight);
    }

    private void makeLadder(int numPeople, int maxHeight) {
        for (int i = 0; i < maxHeight; i++) {
            ladder.add(new Line(numPeople));
        }
    }

    public List<Line> getLadder() {
        return ladder;
    }
}

