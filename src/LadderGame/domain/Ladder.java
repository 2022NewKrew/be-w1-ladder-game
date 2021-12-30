package LadderGame.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    // 인스턴스 변수
    private final Name names;
    private final List<Line> lines;
    private final int column;
    private final int row;

    // 생성자
    public Ladder(String names, int column) throws Exception {
        this.names = new Name(names);
        this.column = column;
        this.row = 2 * this.names.getNamesSize() - 1;
        this.lines = createLines();
    }

    // 메소드
    private List<Line> createLines() throws Exception {
        List<Line> createdLadder = new ArrayList<>();

        for (int i = 0; i < column; i++) {
            Line line = new Line(row);
            createdLadder.add(line);
        }
        return createdLadder;
    }

    public Name getNames() {
        return names;
    }

    public List<Line> getLines(){
        return lines;
    }
}
