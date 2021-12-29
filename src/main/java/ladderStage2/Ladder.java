package ladderStage2;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<Line> ladder = new ArrayList<>();

    public Ladder(int participantCount, int maxHeight) {
        for(int count = 0; count < maxHeight; count++) {
            ladder.add(new Line(participantCount));
        }
    }

    public void viewResult() {
        ladder.forEach(System.out::println);
    }
}
