package domain;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Ladder {
    private static final String BLANK_SPACE = "    ";

    private final List<Line> lines;
    private final List<Person> people;

    public Ladder(List<String> peopleNames, int ladderHeight) {
        LadderValidator.validate(peopleNames, ladderHeight);
        lines = createLines(2 * peopleNames.size() - 1, ladderHeight);
        people = createPeople(peopleNames);
    }

    private List<Line> createLines(int size, int ladderHeight){
        return Stream
                .generate(() -> Line.createLine(size))
                .limit(size)
                .collect(toList());
    }

    private List<Person> createPeople(List<String> peopleNames){
        return peopleNames.stream()
                .map(Person::createPerson)
                .collect(toList());
    }

    @Override
    public String toString() {
        return toStringPeople().concat("\n").concat(toStringLines());
    }

    private String toStringPeople(){
        return people.stream()
                .map(person -> String.format("%7s", person))
                .reduce("", String::concat);
    }

    private String toStringLines(){
        return lines.stream()
                .map(line -> BLANK_SPACE.concat(line.toString().concat("\n")))
                .reduce("", String::concat);
    }
}
