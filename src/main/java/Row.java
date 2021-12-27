import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Row {
    private final List<Boolean> bridges;

    public Row(int people) {
        Random RANDOM = new Random();
        bridges = new ArrayList<>();
        IntStream.range(0, people)
                .forEach(i -> {
                    if (i < people - 1) {
                        bridges.add(RANDOM.nextBoolean());
                    } else {
                        bridges.add(false);
                    }
                });
    }

    @Override
    public String toString() {
        return "|" + bridges.stream()
                .map(e -> e ? "-" : " ")
                .collect(Collectors.joining("|"))
                + "\n";
    }
}
