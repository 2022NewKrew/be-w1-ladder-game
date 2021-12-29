package keith.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class Line {
    private List<Boolean> points = new ArrayList<>();

    public Line(int width, Random random) {
        this.points.add(random.nextBoolean());
        for (int j = 1; j < width - 1; j++) {
            // 왼쪽이 연결되어 있으면 오른쪽은 연결하지 않고, 왼쪽이 연결되어 있지 않으면 오른쪽의 연결 여부를 랜덤으로 한다
            // 즉 this.points.get(j - 1) ? false : random.nextBoolean()인데,
            // 이는 !this.points.get(j - 1) && random.nextBoolean()와 같다
            this.points.add(!this.points.get(j - 1) && random.nextBoolean());
        }
    }

    public List<Boolean> getPoints() {
        return this.points;
    }
}
