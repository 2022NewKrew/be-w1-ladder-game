package application;

import domain.Row;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderFactory {
    public static List<Row> getLadderRows(int numOfPeople, int heightLadder) {
        return IntStream.range(0, heightLadder)
                .mapToObj(e -> new Row(LadderFactory.getBridges(numOfPeople - 1)))
                .collect(Collectors.toList());
    }

    public static List<Boolean> getBridges(int numOfBridges) {
        return IntStream.range(0, numOfBridges)
                .mapToObj(e -> RandomBooleanGenerator.getRandomBoolean())
                .collect(Collectors.toList());
    }
}
