package step3;

import java.util.ArrayList;

public class Line {

    private ArrayList<Boolean> points = new ArrayList<Boolean>();

    public Line() {

    }

    // 마지막 값을 제공
    public boolean getLast() {
        return getIdx(getSize() - 1);
    }

    // 전체 개수를 제공
    public int getSize() {
        return points.size();
    }

    // 값을 추가
    public void addLine(boolean bool) {
        points.add(bool);
    }

    // 해당 index 값을 제공
    public boolean getIdx(int idx) {
        return points.get(idx);
    }
}
