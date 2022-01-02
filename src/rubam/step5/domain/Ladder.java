package rubam.step5.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {

    private final int people;
    private final int height;
    private final List<Line> lines = new ArrayList<>();
    private final List<String> names = new ArrayList<>();
    private final List<String> results = new ArrayList<>();

    public Ladder(int people, int height, List<String> names, List<String> results) {
        this.people = people;
        this.height = height;
        this.names.addAll(names);
        this.results.addAll(results);
        makeLadder();
    }

    private void makeLadder() {
        for (int i = 0; i < height; i++) {
            lines.add(new Line(people));
        }
    }

    public List<Line> getLinesData() {
        return Collections.unmodifiableList(lines);
    }

    public List<String> getNamesData() {
        return Collections.unmodifiableList(names);
    }

    public List<String> getResultsData() {
        return Collections.unmodifiableList(results);
    }
}
