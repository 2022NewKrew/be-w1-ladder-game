package Ladder3;

import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Line {

    private final Random rd = new Random();
    private final ArrayList<Boolean> steps = new ArrayList<>();

    Line (int countOfPerson) {
        for (int i=0; i < countOfPerson - 1; i++)
            steps.add(rd.nextBoolean());
    }

    @Override
    public String toString() {
        return steps.stream()
            .map(step -> step ? "-----" : "     ")
            .collect(Collectors.joining("|", "  |", "|"));
    }
}
