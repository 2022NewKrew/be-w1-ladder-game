package keith.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class Line {
    private final List<Boolean> points = new ArrayList<>();

    protected Line(int width) {
        this.points.add(false);
        Random random = new Random();
        for (int j = 1; j < width; j++) {
            // 왼쪽이 연결되어 있으면 오른쪽은 연결하지 않고, 왼쪽이 연결되어 있지 않으면 오른쪽의 연결 여부를 랜덤으로 한다
            // 즉 this.points.get(j - 1) ? false : random.nextBoolean()
            this.points.add(this.points.get(j - 1) ? false : random.nextBoolean());
        }
        this.points.add(false);
    }

    public List<Boolean> getPoints() {
        return this.points;
    }
}
