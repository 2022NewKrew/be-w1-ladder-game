package domain;

import java.util.List;

public class Ladder {
    private final Lines lines;
    private final People people;

    public Ladder(List<String> peopleNames, int ladderHeight) {
        lines = Lines.valueOf(2 * peopleNames.size() - 1, ladderHeight);
        people = People.valueOf(peopleNames);
    }

    @Override
    public String toString() {
        return people.toString().concat("\n").concat(lines.toString());
    }
}
