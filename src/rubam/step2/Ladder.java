package rubam.step2;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final int people;
    private final int height;
    private final List<Line> ladder = new ArrayList<>();

    public Ladder(int people, int height) {
        this.people = people;
        this.height = height;
        makeLadder();
    }

    private void makeLadder() {
        for (int i = 0; i < height; i++) {
            ladder.add(new Line(people));
        }
    }

    public List<Line> getLadderData() {
        return new ArrayList<>(ladder);
    }
}
