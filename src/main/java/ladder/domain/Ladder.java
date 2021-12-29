package ladder.domain;

import java.util.*;
import java.util.stream.IntStream;

public class Ladder {

    // 참여하는 사람의 수와 사다리의 높이
    private final int numOfPersons;
    private final int ladderHeight;

    // 참여하는 사람들의 이름
    private final List<String> persons;

    // 사다리의 각 행들
    private List<Row> rows;

    // 참여하는 사람들의 이름과 사다리의 높이를 필수 인자로 받도록 했다.
    public Ladder(List<String> persons, int ladderHeight) {
        this.persons = persons;
        this.ladderHeight = ladderHeight;
        this.numOfPersons = persons.size();
        this.makeLadder();
    }


    /*
    참여하는 사람의 수와 사다리 높이를 가지고 새로 사다리를 만드는 메서드
    사다리 높이만큼의 Row를 만들고, 각 Row마다 사다리의 선을 긋는 메서드인 makeLine()을 실행한다.
     */
    private void makeLadder() {
        this.rows = new ArrayList<>();
        IntStream.range(0, this.ladderHeight).forEach(e -> {
            Row row = new Row(this.numOfPersons);
            row.makeLine();
            this.rows.add(row);
        });
    }

    /*
    사다리 연결 정보(rows)로 현재 만들어진 사다리의 형태를 문자열로 반환하는 메서드
    '-----'는 양 옆이 연결돼있다는 뜻이고, '     '(공백)은 양 옆이 연결되지 않았다는 뜻이다.
    */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        this.persons.forEach(person -> sb.append(String.format("%-5s ", person)));
        sb.append("\n");
        this.rows.forEach(sb::append);

        return sb.toString();
    }

    public List<Row> getRows() {
        return this.rows;
    }
}
