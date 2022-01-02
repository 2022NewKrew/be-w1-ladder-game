package rubam.test.step5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import rubam.step5.domain.Ladder;
import rubam.step5.domain.LadderFactory;
import rubam.step5.input.LadderInputException;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderFactoryTest {

    @Test
    void createLadderWrongNamesTest() {
        // given
        String wrongInputNames = "abcdef,abc,def";   // wrong input
        String inputResults = "1,2,3";
        List<String> wrongNames = Arrays.asList(wrongInputNames.split(","));
        List<String> results = Arrays.asList(inputResults.split(","));
        int height = 5;

        // then
        Assertions.assertThrows(LadderInputException.class, () -> {
            LadderFactory.createLadder(wrongNames, height, results);
        });
    }

    @Test
    void createLadderWrongHeightTest() {
        // given
        String inputNames = "abcd,abc,def";
        String inputResults = "1,2,3";
        List<String> names = Arrays.asList(inputNames.split(","));
        List<String> results = Arrays.asList(inputResults.split(","));
        int wrongHeight = -5;    // wrong input

        // then
        Assertions.assertThrows(LadderInputException.class, () -> {
            LadderFactory.createLadder(names, wrongHeight, results);
        });
    }

    @Test
    void createLadderWrongResultsTest() {
        // given
        String inputNames = "abcd,abc,def";
        String wrongInputResults = "1,2";
        List<String> names = Arrays.asList(inputNames.split(","));
        List<String> results = Arrays.asList(wrongInputResults.split(","));
        int height = 5;    // wrong input

        // then
        Assertions.assertThrows(LadderInputException.class, () -> {
            LadderFactory.createLadder(names, height, results);
        });
    }

    @Test
    void createLadderCorrectTest() {
        // given
        String inputNames = "abcd,abc,def";
        String inputResults = "1,2,3";
        List<String> names = Arrays.asList(inputNames.split(","));
        List<String> results = Arrays.asList(inputResults.split(","));
        int height = 5;    // wrong input

        // then
        assertThat(LadderFactory.createLadder(names, height, results)).isInstanceOf(Ladder.class);
    }
}
