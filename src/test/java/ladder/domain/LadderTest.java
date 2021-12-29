package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LadderTest {

    /*
    사다리가 잘 완성됐는지 확인하는 테스트
     */
    @Test
    public void test1() {
        Ladder ladder = new Ladder(List.of("zeki", "todd", "jay", "chris", "jobis", "karon"), 8);
        List<Row> rows = ladder.getRows();

        assertEquals(rows.size(), 8);
        assertEquals(rows.get(0).getLinked().size(), 5);
    }
}