package application;

import domain.Line;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LineGeneratorFactory {
    public static List<Line> getLadderLines(int numOfBridges, int heightLadder) {
        return IntStream.range(0, heightLadder)
                .mapToObj(e -> new Line(LineGeneratorFactory.getBridges(numOfBridges)))
                .collect(Collectors.toList());
    }

    private static List<Boolean> getBridges(int numOfBridges) {
        return IntStream.range(0, numOfBridges)
                .mapToObj(e -> RandomBooleanGenerator.getRandomBoolean())
                .collect(Collectors.toList());
    }
}
