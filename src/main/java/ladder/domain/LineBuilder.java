package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class LineBuilder {
    private final Random random = new Random();
    private final int numberOfPlayer;

    LineBuilder(int numberOfPlayer) {
        this.numberOfPlayer = numberOfPlayer;
    }

    /**
     * 가로 막대를 포함시킬지 말지 결정하는 메서드
     *
     * @return 포함시키면 true를 포함시키지 않으면 false를 반환한다
     */
    private Boolean getRung() {
        return random.nextBoolean();
    }

    private Boolean getValidRung(Boolean beforeRung, Boolean afterRung) {
        if (beforeRung && afterRung)
            return false;
        return afterRung;
    }

    /**
     * Line을 만드는 메서드
     * 한 줄을 만들어서 반환한다
     *
     * @return ladder.domain.Line 객체를 반환한다
     */
    Line makeLine() {
        List<Boolean> line = new ArrayList<>();

        line.add(getRung());
        for (int i = 1; i < numberOfPlayer - 1; i++) {
            Boolean nowElement = getRung();
            line.add(getValidRung(line.get(i - 1), nowElement));
        }
        return new Line(line);
    }
}
