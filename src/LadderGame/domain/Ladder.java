package LadderGame.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    // 인스턴스 변수
    private final UserList userList;
    private final List<Line> lines = new ArrayList<>();

    // 생성자
    public Ladder(String names, int column) throws Exception {
        this.names = new Name(names);
        createLines(column);
    }

    // 메소드
    private void createLines(int column) throws Exception {
        checkColumnValid(column);
        int row = 2 * this.names.getNamesSize() - 1;

        for (int i = 0; i < column; i++) {
            Line line = new Line(row);
            lines.add(line);
        }
    }

    protected void checkColumnValid(int row) throws Exception {
        if (row <= 0) {
            throw new Exception("사다리의 높이는 0보다 커야합니다.");
        }
    }

    public Name getNames() {
        return names;
    }

    public List<Line> getLines() {
        return lines;
    }
}
