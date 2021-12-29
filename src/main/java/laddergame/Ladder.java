package laddergame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {
    private final List<Line> lineList = new ArrayList<>();

    public Ladder(int numberOfGamer, int ladderHeight) {
        for (int i = 0; i < ladderHeight; i++) {
            lineList.add(Line.from(numberOfGamer));
        }
    }

    public List<Line> getLineList() {
        return Collections.unmodifiableList(lineList);
    }
}
