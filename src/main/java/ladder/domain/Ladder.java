package ladder.domain;

import java.util.ArrayList;
import java.util.List;

//사다리 정보
public class Ladder {
    private List<Line> ladder; //실질적인 사다리를 나타내는 컬렉션

    //높이,너비 데이터 바탕으로 생성하는 생성자
    public Ladder(int playerCnt) {
        ladder = new ArrayList<>(playerCnt);
    }

    // 사다리 초기화
    public void initLadder(int playerCnt, int height) {
        ladder.clear();

        for (int i = 0; i < playerCnt; i++) {
            ladder.add(new Line(height));
        }
    }

    public int getHeight() {
        return ladder.get(0).getHeight();
    }

    public List<Line> getLadder() {
        return ladder;
    }

    // 인덱스에 해당하는 라인
    public Line getOneLine(int index) {
        return ladder.get(index);
    }
}
