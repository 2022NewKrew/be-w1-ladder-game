import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LineTest {
    static LadderRow ladderRow;

    @BeforeEach
    void setUp(){
        System.out.println("line test start");
        ladderRow = LadderRow.getInstance(0);
    }

    @AfterEach
    void tearDown(){
        System.out.println("line test done");
    }

    @Test
    void decideHorizonTest(){
        ladderRow.getRow().add(LadderCell.getInstance(true));
        System.out.println(ladderRow.getRow().get(0).getIsHorizontal());
        assertThat(ladderRow.decideHorizon(ladderRow.getRow(), 1)).isEqualTo(false);
    }

}
