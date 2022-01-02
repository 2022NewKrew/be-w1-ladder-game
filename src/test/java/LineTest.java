import Domain.LadderCell;
import Domain.LadderCells;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.*;

public class LineTest {
    static LadderCells ladderCells;

    @BeforeEach
    void setUp() {
        System.out.println("line test start");
        ladderCells = new LadderCells(0);
    }

    @AfterEach
    void tearDown() {
        System.out.println("line test done");
    }

    @Test
    void decideHorizonTest() {
        ladderCells.add(new LadderCell(true));
        assertThat(ladderCells.decideHorizon(1)).isEqualTo(false);
    }


}
