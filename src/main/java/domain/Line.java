package domain;

import java.util.List;

public class Line {
    private List<Integer> points;

    public Line (List<Integer> points) {
        this.points = points;
    }

    public List<Integer> getPoints() {
        return points;
    }
}

