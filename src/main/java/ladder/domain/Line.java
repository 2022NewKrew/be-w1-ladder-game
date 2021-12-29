package ladder.domain;

import java.util.ArrayList;
import java.util.List;

// 사다리를 구성하는 한 라인
public class Line {
    private List<Bridge> line; //라인은 브릿지의 모음

    public Line(int height) {
        line = new ArrayList<>(height);
    }

    //라인 초기화
    public void initLine(int height) {
        line.clear();

        for (int i = 0; i < height; i++) {
            line.add(new Bridge());
        }
    }

    public List<Bridge> getLine() {
        return line;
    }

    public int getHeight() {
        return line.size();
    }

    public Bridge getOneBridge(int index) {
        return line.get(index);
    }
}
