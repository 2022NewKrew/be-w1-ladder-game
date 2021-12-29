package laddergame.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {
    private final List<Line> lineList;

    public Ladder(List<Line> lineList) {
        this.lineList = new ArrayList<>(lineList);
    }

    public static Ladder of(int numberOfGamer, int ladderHeight) {
        List<Line> lineList = new ArrayList<>();
        for (int i = 0; i < ladderHeight; i++) {
            lineList.add(Line.from(numberOfGamer));
        }
        return new Ladder(lineList);
    }

    public List<Line> getLineList() {
        return Collections.unmodifiableList(lineList);
    }
}
