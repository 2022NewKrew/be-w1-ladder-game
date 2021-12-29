package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class RowTest {

    /*
    만들어진 Row에서 양갈래 라인이 생성되는지 테스트
    라인은 랜덤으로 생성되므로, 여러 번 반복을 통해 테스트합니다.
     */
    @Test
    public void test1() {
        Row row = new Row(100);
        IntStream.range(0, 10000).forEach(i -> {
            row.makeLine();
            assertTrue(isCompleted(row));
        });
    }

    private boolean isCompleted(Row row) {
        boolean res = true;
        List<Boolean> linked = row.getLinked();
        for (int i = 0; i < linked.size() - 1; i++) {
            res = !(linked.get(i) && linked.get(i + 1));
        }

        return res;
    }
}