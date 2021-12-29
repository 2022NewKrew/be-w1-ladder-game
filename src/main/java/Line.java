import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {

    private final int personNum;
    private final List<Boolean> line = new ArrayList<>();
    private String result = "   |";

    public Line(int personNum) {
        this.personNum = personNum;
        makeLine();

    }

    private void makeLine() {
        Random random = new Random();
        for (int i = 0; i < personNum - 1; i++) {
            line.add(random.nextBoolean());
        }
        updateLine();
    }

    //만들어진 라인에서 유효하지 않은 사다리를 지우는 메서드
    private void updateLine() {
        for (int i = 1; i < personNum - 1; i++) {
            checkLeft(i);
        }
    }

    //사다리가 연속되면 하나를 지우는 메서드
    private void checkLeft(int idx) {
        if (line.get(idx - 1) && line.get(idx)) {
            line.set(idx, false);
        }
    }


    @Override
    public String toString() {
        for (boolean b : line) {
            result += b ? "-----|" : "     |";
        }
        return result;
    }
}
