package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LadderTest {

    /*
    사다리가 잘 완성됐는지 확인하는 테스트
     */
    @Test
    public void ladderCompleteTest() {
        int numOfPersons = 6;
        int ladderHeight = 8;
        Ladder ladder = new Ladder(List.of("zeki", "todd", "jay", "chris", "jobis", "karon"), ladderHeight, List.of("1000", "2000", "3000", "4000", "5000", "6000"));
        ladder.rideLadder();
        List<Row> rows = ladder.getRows();

        assertEquals(ladderHeight, rows.size());
        assertEquals(numOfPersons - 1, rows.get(0).getLinked().size());
    }
}