package rubam.test.step5;

import org.junit.jupiter.api.Test;
import rubam.step5.domain.Ladder;
import rubam.step5.domain.Line;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    @Test
    void getNamesDataTest() {
        // given
        String inputNames = "a,b,c,d,e";
        String inputResults = "1,2,3,4,5";
        int height = 7;
        List<String> names = Arrays.asList(inputNames.split(","));
        List<String> results = Arrays.asList(inputResults.split(","));
        Ladder ladder = new Ladder(names.size(), height, names, results);

        // when
        List<String> namesData = ladder.getNamesData();

        // then
        assertThat(namesData).isEqualTo(names);
    }

    @Test
    void getDataTest() {
        // given
        String inputNames = "a,b,c,d,e";
        String inputResults = "";
        int height = 7;
        List<String> names = Arrays.asList(inputNames.split(","));
        List<String> results = Arrays.asList(inputResults.split(","));
        Ladder ladder = new Ladder(names.size(), height, names, results);

        // when
        List<Line> linesData = ladder.getLinesData();

        // then
        assertThat(linesData.size()).isEqualTo(height);
    }
}
