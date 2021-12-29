import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {

    // 클래스 변수 및 상수
    private static final Character LADEER = 'ㅣ';
    private static final Character EMPTY = ' ';
    private static final Character BRIDGE = '-';

    private static final Random random = new Random();

    // 인스턴스 변수
    private final int column;
    private final int row;
    private final List<List<Character>> ladder;

    // 생성자
    public Ladder(int[] inputNumber) {
        this.column = inputNumber[1];
        this.row = 2 * inputNumber[0] - 1;
        this.ladder = getLadder();
    }

    // 메소드
    private List<List<Character>> getLadder() {
        List<List<Character>> createdLadder = new ArrayList<>();

        for (int i = 0; i < column; i++) {
            List<Character> line = IntStream.range(0, row).mapToObj(this::getLadderElement).collect(Collectors.toList());
            createdLadder.add(line);
        }
        return createdLadder;
    }

    private Character getLadderElement(int columnNumber) {
        if (columnNumber % 2 == 0) {
            return LADEER;
        }

        boolean isLadderBridge = getRandomBridgeByPercent(50);
        if (isLadderBridge) {
            return BRIDGE;
        }
        return EMPTY;
    }

    private boolean getRandomBridgeByPercent(int percent) {
        return random.nextInt(100) >= percent;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        ladder.forEach(line -> {
            line.forEach(result::append);
            result.append("\n");
        });
        return result.toString();
    }
}
