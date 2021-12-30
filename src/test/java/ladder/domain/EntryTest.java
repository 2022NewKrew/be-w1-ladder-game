package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class EntryTest {

    @Test
    public void 선_그리기_테스트() {

    }

    @Test
    public void 참가자_이름_5자_테스트() {
        // given
        Entry testEntry = new Entry("Ladder", 5);

        //when
        String expected = "Ladde";

        //then
        Assertions.assertThat(testEntry.toString()).isEqualTo(expected);
    }

}