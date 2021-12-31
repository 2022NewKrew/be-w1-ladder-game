package bin.jayden.ladder_game.domain;

import java.util.ArrayList;
import java.util.List;

public class LadderRow {
    private final List<Boolean> row = new ArrayList<>();

    public LadderRow(int width, LineGenerator rowGenerator) {
        boolean beforeValue = false;
        for (int i = 0; i < width - 1; i++) {
            beforeValue = !beforeValue && rowGenerator.lineGenerate(); // 바로 이전의 값이 True였다면 무조건 False가 할당되도록 설정
            row.add(beforeValue);
        }
    }

    public List<Boolean> getRow() {
        return row;
    }

    public boolean getIsLine(int index) {
        return row.get(index);
    }


}
