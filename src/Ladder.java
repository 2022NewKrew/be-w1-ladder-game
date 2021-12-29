import java.util.ArrayList;
import java.util.List;

public class Ladder {
    // 인스턴스 변수
    private final int column;
    private final int row;
    private final List<Line> ladder;

    // 생성자
    public Ladder(int row, int column) {
        this.column = column;
        this.row = 2 * row - 1;
        this.ladder = getLadder();
    }

    // 메소드
    private List<Line> getLadder() {
        List<Line> createdLadder = new ArrayList<>();

        for (int i = 0; i < column; i++) {
            Line line = new Line(row);
            createdLadder.add(line);
        }
        return createdLadder;
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
