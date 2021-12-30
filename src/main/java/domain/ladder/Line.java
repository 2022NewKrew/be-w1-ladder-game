package domain.ladder;

import java.util.List;

// ladderShpae 의 한 줄을 담은 클래스
public class Line {
    // points 는 한 줄을 의미
    private List<Integer> points;

    public Line (List<Integer> points) {
        this.points = points;
    }

    public List<Integer> getPoints() {
        return points;
    }
}

