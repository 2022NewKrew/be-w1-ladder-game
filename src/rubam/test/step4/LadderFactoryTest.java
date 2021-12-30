package rubam.test.step4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import rubam.step4.domain.Ladder;
import rubam.step4.domain.LadderFactory;
import rubam.step4.input.LadderInputException;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LadderFactoryTest {

    @Test
    void createLadderWrongNamesTest() {
        // given
        String wrongInputNames = "abcdef,abc,def";   // wrong input
        List<String> wrongNames = Arrays.asList(wrongInputNames.split(","));
        int height = 5;

        // then
        Assertions.assertThrows(LadderInputException.class, () -> {
            LadderFactory.createLadder(wrongNames, height);
        });
    }

    @Test
    void createLadderWrongHeightTest() {
        // given
        String inputNames = "abcd,abc,def";
        List<String> names = Arrays.asList(inputNames.split(","));
        int wrongHeight = -5;    // wrong input

        // then
        Assertions.assertThrows(LadderInputException.class, () -> {
            LadderFactory.createLadder(names, wrongHeight);
        });
    }

    @Test
    void createLadderCorrectTest() {
        // given
        String inputNames = "abcd,abc,def";
        List<String> names = Arrays.asList(inputNames.split(","));
        int height = 5;    // wrong input

        // then
        assertThat(LadderFactory.createLadder(names, height)).isInstanceOf(Ladder.class);
    }
}
