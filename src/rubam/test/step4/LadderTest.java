package rubam.test.step4;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import rubam.step4.domain.Ladder;
import rubam.step4.domain.Line;

import java.util.Arrays;
import java.util.List;

public class LadderTest {

    @Test
    void getNamesDataTest() {
        // given
        String input = "a,b,c,d,e";
        int height = 7;
        List<String> names = Arrays.asList(input.split(","));
        Ladder ladder = new Ladder(names.size(), height, names);

        // when
        List<String> namesData = ladder.getNamesData();

        // then
        assertThat(namesData).isEqualTo(names);
    }

    @Test
    void getDataTest() {
        // given
        String input = "a,b,c,d,e";
        int height = 7;
        List<String> names = Arrays.asList(input.split(","));
        Ladder ladder = new Ladder(names.size(), height, names);

        // when
        List<Line> linesData = ladder.getLinesData();

        // then
        assertThat(linesData.size()).isEqualTo(height);
    }
}
