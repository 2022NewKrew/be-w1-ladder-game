package ladder.domain;

import java.util.ArrayList;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Line {
    private final ArrayList<Boolean> points = new ArrayList<>();
    private final Random rand = new Random();

    public Line (int countOfPerson) {
        // 라인의 좌표 값에 선이 있는지 유무를 판단하는 로직 추가
        boolean previous = true;
        for(int i = 0; i < countOfPerson-1; i++) {
            previous = checkDuplicatedLine(previous);
        }
    }

    // Constructor for unit test
    // 유닛 테스트를 위해 임의의 line 을 생성할 수 있는 생성자를 추가함.
    public Line (ArrayList<Boolean> points) {
        this.points.addAll(points);
    }

    private boolean checkDuplicatedLine(boolean previous) {
        if (previous) {
            boolean current = rand.nextBoolean();
            points.add(current);
            return current;
        }

        points.add(true);
        return true;
    }

    public void test_checkDuplicatedLine() {
        assertTrue(checkDuplicatedLine(false));
    }

    public ArrayList<Boolean> getPoints() {
        return this.points;
    }
}
