import java.util.List;
import java.util.ArrayList;

public class Ladder {
    private final int numberOfLegs;
    private final int height;

    private final List<Line> ladder;

    Ladder(int numberOfPeople, int height) {
        this.numberOfLegs = numberOfPeople;
        this.height = height;

        ladder = new ArrayList<>();
        for(int i = 0; i < height; i++)
            ladder.add(new Line(numberOfLegs));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ladder.forEach(line -> sb.append(line).append("\n"));

        return sb.toString();
    }
}
