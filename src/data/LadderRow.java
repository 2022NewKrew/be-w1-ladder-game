package data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LadderRow {
    private static final Random random = new Random();
    private final List<Boolean> row = new ArrayList<>();

    public LadderRow(int width) {
        boolean beforeValue = false;
        for (int i = 0; i < width - 1; i++) {
            beforeValue = !beforeValue && random.nextBoolean(); //바로 이전의 값이 True였다면 무조건 False가 할당되도록 설정
            row.add(beforeValue);
        }
    }

    public List<Boolean> getRow() {
        return row;
    }
}
