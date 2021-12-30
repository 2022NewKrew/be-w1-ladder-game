package domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<Line> ladder;

    public Ladder(int numOfPeople, int height) {
        ladder = new ArrayList<>();

        for(int i=0; i<height; i++){
            ladder.add(new Line(numOfPeople));
        }
    }

    public List<Line> getLadder() {
        return ladder;
    }
}
