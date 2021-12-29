package application;

import domain.Row;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderFactory {
    public static List<Row> getLadderRows(int numOfBridges, int heightLadder) {
        return IntStream.range(0, heightLadder)
                .mapToObj(e -> new Row(LadderFactory.getBridges(numOfBridges)))
                .collect(Collectors.toList());
    }

    private static List<Boolean> getBridges(int numOfBridges) {
        return IntStream.range(0, numOfBridges)
                .mapToObj(e -> RandomBooleanGenerator.getRandomBoolean())
                .collect(Collectors.toList());
    }
}
