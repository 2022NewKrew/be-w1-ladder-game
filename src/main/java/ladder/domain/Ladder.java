package ladder.domain;

import static ladder.domain.Line.makeLine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {

    private final List<Line> lines;

    public Ladder(ArrayList<Line> lines) {
        this.lines = new ArrayList<>(lines);
    }

    public static Ladder makeLadder(int countOfPerson, int ladderHeight) {
        validate(countOfPerson,ladderHeight);
        ArrayList<Line> lines = new ArrayList<>();
        for (int i = 0; i < ladderHeight; i++) {
            lines.add(makeLine(countOfPerson));
        }
        return new Ladder(lines);
    }

    private static void validate(int countOfPerson, int ladderHeight) {
        if(countOfPerson<=0){
            throw new IllegalArgumentException("사람 수는 0명 이하일 수 없습니다.");
        }
        if(ladderHeight<=0){
            throw new IllegalArgumentException("사다리 높이는 0 이하일 수 없습니다.");
        }
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(this.lines);
    }
}
