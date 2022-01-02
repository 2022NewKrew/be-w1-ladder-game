package rubam.test.step5;

import org.junit.jupiter.api.Test;
import rubam.step5.domain.Ladder;
import rubam.step5.model.ResultCalculator;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

public class ResultCalculatorTest {

    @Test
    void getGameResultsTest() {
        // given
        String inputNames = "a,b,c,d,e";
        String inputResults = "1,2,3,4,5";
        int height = 7;
        List<String> names = Arrays.asList(inputNames.split(","));
        List<String> results = Arrays.asList(inputResults.split(","));
        Ladder ladder = new Ladder(names.size(), height, names, results);

        // when
        ResultCalculator resultCalculator = new ResultCalculator(ladder);

        // then
        assertThat(resultCalculator.getGameResult(0)).isBetween(0, 5);
    }

    @Test
    void getAllGameResultsTest() {
        // given
        String inputNames = "a,b,c,d,e";
        String inputResults = "1,2,3,4,5";
        int height = 7;
        List<String> names = Arrays.asList(inputNames.split(","));
        List<String> results = Arrays.asList(inputResults.split(","));
        Ladder ladder = new Ladder(names.size(), height, names, results);

        // when
        ResultCalculator resultCalculator = new ResultCalculator(ladder);

        // then
        assertThat(resultCalculator.getAllGameResults().size()).isEqualTo(names.size());
    }
}
