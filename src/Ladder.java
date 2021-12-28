import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Ladder {
    // 상수
    private static final String column = "|";
    private static final String connected = "-";
    private static final String notConnected = " ";

    // 인스턴스 변수
    private final List<List<Boolean>> ladder;

    // 생성자
    public Ladder(int people, int height) {
        this.ladder = new ArrayList<>();
        Random random = new Random();

        for (int i=0; i < height; i++) {
            this.ladder.add(createRow(people, random));
        }
    }

    // 메서드
    private List<Boolean> createRow(int people, Random random) {
        List<Boolean> result = new ArrayList<>();
        for (int i=0; i < people - 1; i++) {
            result.add(random.nextBoolean());
        }
        return result;
    }

    public String toString() {
        List<List<String>> stringLadder = new ArrayList<>();

        for (List<Boolean> booleanRow : this.ladder) {
            stringLadder.add(createRowString(booleanRow));
        }

        return stringLadder.stream()
                .map(s -> String.join("", s))
                .collect(Collectors.joining("\n"));
    }

    private List<String> createRowString(List<Boolean> booleanRow) {
        List<String> result = new ArrayList<>();
        for (Boolean isConnected : booleanRow) {
            result.add(column);
            result.add(isConnected ? connected : notConnected);
        }
        result.add(column);

        return result;
    }

}
