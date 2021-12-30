package domain;

import java.util.List;

public class Ladder {
    private final Lines lines;
    private final People people;

    public Ladder(List<String> peopleNames, int ladderHeight) {
        lines = new Lines(2 * peopleNames.size() - 1, ladderHeight);
        people = new People(peopleNames);
    }

    @Override
    public String toString() {
        return people.toString().concat("\n").concat(lines.toString());
    }
}
