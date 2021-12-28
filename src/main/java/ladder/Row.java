package ladder;

import java.util.ArrayList;
import java.util.List;

public class Row {
    private int numOfColumns;
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
        for (int i = 0; i < this.numOfColumns - 1; i++) {
            boolean temp = false;
            if(i == 0 || !this.linked.get(i - 1)) {
                temp = Math.random() >= 0.5;
            }
            this.linked.add(temp);
        }
    }

    public List<Boolean> getLinked() {
        return this.linked;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("|");
        this.linked.forEach(e -> sb.append(e ? "-----" : "     ").append("|"));
        sb.append("\n");

        return sb.toString();
    }
}
