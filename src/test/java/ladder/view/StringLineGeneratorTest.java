package ladder.view;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class StringLineGeneratorTest {

    @Test
    void 줄_만들기_테스트() {
        // given
        StringLineGenerator stringLineGenerator = new StringLineGenerator();

        // when
        List<Boolean> testPoints = List.of(Boolean.FALSE, Boolean.TRUE);
        String testString =
                stringLineGenerator.createRowString(testPoints, "|", "-", " ", 1);

        // then
        Assertions.assertThat(testString).isEqualTo("| |-|");

    }
}