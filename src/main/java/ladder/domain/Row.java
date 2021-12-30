package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Row {
    private static final String PILLAR = "|";
    private static final String IS_LINKED = "-----";
    private static final String IS_NOT_LINKED = "     ";
    private static final String NEW_LINE = "\n";
    private static final double THRESHOLD_RANDOM_LINE = 0.5;
    private final int numOfColumns;
    private List<Boolean> linked;

    public Row(int numOfColumns) {
        this.numOfColumns = numOfColumns;
    }

    /*
    라인이 겹치지 않도록 하기 위해
    현재 줄에서 왼쪽에 이미 라인이 있다면 라인을 생성할 수 없도록 구현했습니다.
    또한 만약 현재 줄이 가장 왼쪽 줄이라면(i == 0), 랜덤하게 라인을 생성하도록 구현했습니다.
    현재 줄에서 라인을 생성할 수 있는 경우, 라인을 50% 확률로 생성하도록 구현했습니다.
     */
    public void makeLine() {
        this.linked = new ArrayList<>();

        IntStream.range(0, this.numOfColumns - 1)
                 .forEach(this::createLine);
    }

    private void createLine(int i) {
        boolean hasLink = false;
        if(isPossibleToLink(i)) {
            hasLink = Math.random() >= THRESHOLD_RANDOM_LINE;
        }
        this.linked.add(hasLink);
    }

    private boolean isPossibleToLink(int i) {
        if(i == 0) {
            return true;
        }

        return !this.linked.get(i - 1);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(PILLAR);
        this.linked.forEach(e -> sb.append(e ? IS_LINKED : IS_NOT_LINKED).append(PILLAR));
        sb.append(NEW_LINE);

        return sb.toString();
    }

    public List<Boolean> getLinked() {
        return this.linked;
    }
}
