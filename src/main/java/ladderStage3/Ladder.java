package ladderStage3;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<Line> ladder = new ArrayList<>();

    public Ladder(Participants participants, int maxHeight) {
        for(int count = 0; count < maxHeight; count++) {
            ladder.add(new Line(participants.size()));
        }
    }

    public void viewResult(Participants participants) {
        viewNames(participants);
        System.out.println();
        ladder.forEach(System.out::println);
    }

    private void viewNames(Participants participants) {
        List<String> names = participants.getNames();
        for(String name : names) {
            System.out.printf("%-6s", name);
        }
    }
}