package ladder.view;

import java.util.List;
import java.util.Random;

public class PointGenerator {
    // 인스턴스 변수
    private final Random random;

    // 생성자
    public PointGenerator() {
        this.random = new Random();
    }

    // 메서드
    public Boolean addPoint(List<Boolean> points) {
        if (points.size() == 0) {
            return random.nextBoolean();
        }

        return points.get(points.size() - 1) ? Boolean.FALSE : random.nextBoolean();
    }
}
