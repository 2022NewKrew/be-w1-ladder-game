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

    // 사다리의 각 결과들
    private final List<String> results;

    private Map<String, String> matched;

    // 참여하는 사람들의 이름과 사다리의 높이를 필수 인자로 받도록 했다.
    public Ladder(List<String> persons, int ladderHeight, List<String> results) {
        this.persons = persons;
        this.ladderHeight = ladderHeight;
        this.numOfPersons = persons.size();
        this.results = results;
    }

    /*
    실제 사다리를 타는 메서드
    사다리를 만들고 ( makeLadder() ), 결과를 매칭시킨다 ( matchPerson() ).
    */
    public void rideLadder() {
        this.makeLadder();
        this.matchPerPerson();
    }

    // 각각의 사람들을 사다리를 태워 결과에 매칭시키는 메서드.
    private void matchPerPerson() {
        this.matched = new HashMap<>();
        IntStream.range(0, this.numOfPersons).forEach(this::match);
    }


    /*
    참여하는 사람들의 이름이 저장된 persons 리스트의 x 인덱스에 해당하는 사람을 사다리 태우는 메서드
    끝에 도달하면, 그 결과를 matched에 저장한다.
     */
    private void match(int x) {
        int curY = -1;
        int curX = x;
        for (int j = 0; j < this.ladderHeight; j++) {
            ++curY;
            curX = this.goDown(curY, curX);
        }
        this.matched.put(this.persons.get(x), this.results.get(curX));
    }

    /*
    사다리의 현재 칸에서 밑층으로 내려가는 메서드
    왼쪽 / 오른쪽으로 갈 수 있다면 가고난 후의 x좌표를 반환한다.
     */
    private int goDown(int curY, int x) {
        if(this.possibleLeft(curY, x)) {
            return x - 1;
        }
        if(this.possibleRight(curY, x)) {
            return x + 1;
        }
        return x;
    }

    /*
    현재 칸에서 오른쪽으로 내려갈 수 있는지를 판단하는 메서드
    현재 칸이 오른쪽 끝이거나, 현재 칸에서 오른쪽으로 가는 라인이 없다면 false를, 아니면 true 반환
     */
    private boolean possibleRight(int curY, int x) {
        if(x == this.numOfPersons - 1) {
            return false;
        }

        return this.rows.get(curY).getLinked().get(x);
    }

    /*
    현재 칸에서 왼쪽으로 내려갈 수 있는지를 판단하는 메서드
    현재 칸이 왼쪽 끝이거나, 현재 칸에서 왼쪽으로 가는 라인이 없다면 false를, 아니면 true 반환
    */
    private boolean possibleLeft(int curY, int x) {
        if(x == 0) {
            return false;
        }

        return this.rows.get(curY).getLinked().get(x - 1);
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

        sb.append("사다리 결과\n");
        this.persons.forEach(person -> sb.append(String.format("%-5s ", person)));
        sb.append("\n");
        this.rows.forEach(sb::append);
        this.results.forEach(result -> sb.append(String.format("%-5s ", result)));

        return sb.toString();
    }

    public List<Row> getRows() {
        return this.rows;
    }

    public Map<String, String> getMatched() {
        return this.matched;
    }
}
