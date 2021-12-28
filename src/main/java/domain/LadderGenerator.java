package domain;

import java.util.List;

public class LadderGenerator {

    // 기본 2차원 사다리 생성
    private final List<LineGenerator> ladder;

    public LadderGenerator(List<LineGenerator> ladder) {
        this.ladder = ladder;
    }

    public List<LineGenerator> getLadder() {
        return ladder;
    }

    public LineGenerator getLineGenerator(int point) {
        return ladder.get(point);
    }
}
