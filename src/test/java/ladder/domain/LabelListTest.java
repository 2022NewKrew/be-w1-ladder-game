package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class LabelListTest {

    @Test
    public void 참가자_이름_5자_테스트() {
        // given
        LabelList testLabelList = new LabelList("Ladder,Test", 5);

        //when
        String expectedFiveOver = "Ladde";
        String expectedFiveUnder = "Test ";

        //then
        Assertions.assertThat(testLabelList.toString()).isEqualTo(expectedFiveOver + " " + expectedFiveUnder);
    }

}