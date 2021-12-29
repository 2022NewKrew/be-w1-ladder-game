package ladder;

import java.util.ArrayList;
import java.util.List;

public class Bridge {
    private final List<Boolean> points;

    public Bridge() {
        this.points = new ArrayList<>();
    }

    public void addPoint(boolean isConnect) {
        points.add(isConnect);
    }

    public boolean isConnected(int point) {
        return points.get(point);
    }

}
