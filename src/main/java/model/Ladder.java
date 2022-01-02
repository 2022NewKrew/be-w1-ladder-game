package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final List<Line> ladder;
    private List<String> namePeople;

    public Ladder(List<String> namePeople, int numPeople, int maxHeight){
        ladder = IntStream
                .range(0,maxHeight)
                .mapToObj(i -> new Line(numPeople))
                .collect(Collectors.toList());

        this.namePeople = namePeople;
    }

    @Override
    public String toString(){
        return ladder.stream()
                .map(Line::toString)
                .collect(Collectors.joining("\n"));
    }

    public List<String> getNamePeople() {
        return namePeople;
    }
}

