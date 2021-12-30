package ladder.domain;

import ladder.view.PointGenerator;
import ladder.view.StringLineGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Ladder {
    // 상수
    private static final int PARTICIPANT_LIMIT = 5;

    // 인스턴스 변수
    private final List<Line> ladder;
    private final Entry entry;

    // 생성자
    public Ladder(String stringEntry, int height) {
        this.entry = new Entry(stringEntry, PARTICIPANT_LIMIT);
        int peopleCount = this.entry.getEntryCount();
        this.ladder = new ArrayList<>();

        for (int i=0; i < height; i++) {
            this.ladder.add(new Line(peopleCount, PARTICIPANT_LIMIT, new StringLineGenerator(), new PointGenerator()));
        }
    }

    // 메서드
    public String toString() {
        return entry.toString() + "\n" +
                this.ladder.stream()
                .map(Line::toString)
                .collect(Collectors.joining("\n"));
    }
}
