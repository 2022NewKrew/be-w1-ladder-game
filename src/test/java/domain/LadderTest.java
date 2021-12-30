package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

public class LadderTest {

    @Test
    void getSingleResult_QueryInParticipants_ReturnsCorrectResult() {
        // Arrange
        List<Boolean> horizontalLinesInLayer1 = new ArrayList<>();
        horizontalLinesInLayer1.add(true);
        horizontalLinesInLayer1.add(false);
        horizontalLinesInLayer1.add(false);
        Layer layer1 = new Layer(horizontalLinesInLayer1);

        List<Boolean> horizontalLinesInLayer2 = new ArrayList<>();
        horizontalLinesInLayer2.add(false);
        horizontalLinesInLayer2.add(true);
        horizontalLinesInLayer2.add(false);
        Layer layer2 = new Layer(horizontalLinesInLayer2);

        List<Boolean> horizontalLinesInLayer3 = new ArrayList<>();
        horizontalLinesInLayer3.add(true);
        horizontalLinesInLayer3.add(false);
        horizontalLinesInLayer3.add(true);
        Layer layer3 = new Layer(horizontalLinesInLayer3);

        List<Layer> layers = new ArrayList<>();
        layers.add(layer1);
        layers.add(layer2);
        layers.add(layer3);

        List<String> participants = new ArrayList<>();
        participants.add("testUser1");
        participants.add("testUser2");
        participants.add("testUser3");
        participants.add("testUser4");

        List<String> results = new ArrayList<>();
        results.add("testResult1");
        results.add("testResult2");
        results.add("testResult3");
        results.add("testResult4");

        Ladder ladder = new Ladder(participants, results, layers);
        ladder.buildResultMap();

        // Act & Assert
        assertThat(ladder.getSingleResult("testUser1")).isEqualTo("testResult4");
        assertThat(ladder.getSingleResult("testUser2")).isEqualTo("testResult2");
        assertThat(ladder.getSingleResult("testUser3")).isEqualTo("testResult1");
        assertThat(ladder.getSingleResult("testUser4")).isEqualTo("testResult3");
    }

    @Test
    void getSingleResult_QueryNotInParticipants_ReturnsCorrectMessage() {
        // Arrange
        List<Boolean> horizontalLinesInLayer1 = new ArrayList<>();
        horizontalLinesInLayer1.add(true);
        horizontalLinesInLayer1.add(false);
        horizontalLinesInLayer1.add(false);
        Layer layer1 = new Layer(horizontalLinesInLayer1);

        List<Boolean> horizontalLinesInLayer2 = new ArrayList<>();
        horizontalLinesInLayer2.add(false);
        horizontalLinesInLayer2.add(true);
        horizontalLinesInLayer2.add(false);
        Layer layer2 = new Layer(horizontalLinesInLayer2);

        List<Boolean> horizontalLinesInLayer3 = new ArrayList<>();
        horizontalLinesInLayer3.add(true);
        horizontalLinesInLayer3.add(false);
        horizontalLinesInLayer3.add(true);
        Layer layer3 = new Layer(horizontalLinesInLayer3);

        List<Layer> layers = new ArrayList<>();
        layers.add(layer1);
        layers.add(layer2);
        layers.add(layer3);

        List<String> participants = new ArrayList<>();
        participants.add("testUser1");
        participants.add("testUser2");
        participants.add("testUser3");
        participants.add("testUser4");

        List<String> results = new ArrayList<>();
        results.add("testResult1");
        results.add("testResult2");
        results.add("testResult3");
        results.add("testResult4");

        Ladder ladder = new Ladder(participants, results, layers);
        ladder.buildResultMap();

        // Act & Assert
        assertThat(ladder.getSingleResult("testUser5")).isEqualTo("해당 참가자가 존재하지 않습니다.");
    }

    @Test
    void getEveryResults_ReturnsCorrectResult() {
        // Arrange
        List<Boolean> horizontalLinesInLayer1 = new ArrayList<>();
        horizontalLinesInLayer1.add(true);
        horizontalLinesInLayer1.add(false);
        horizontalLinesInLayer1.add(false);
        Layer layer1 = new Layer(horizontalLinesInLayer1);

        List<Boolean> horizontalLinesInLayer2 = new ArrayList<>();
        horizontalLinesInLayer2.add(false);
        horizontalLinesInLayer2.add(true);
        horizontalLinesInLayer2.add(false);
        Layer layer2 = new Layer(horizontalLinesInLayer2);

        List<Boolean> horizontalLinesInLayer3 = new ArrayList<>();
        horizontalLinesInLayer3.add(true);
        horizontalLinesInLayer3.add(false);
        horizontalLinesInLayer3.add(true);
        Layer layer3 = new Layer(horizontalLinesInLayer3);

        List<Layer> layers = new ArrayList<>();
        layers.add(layer1);
        layers.add(layer2);
        layers.add(layer3);

        List<String> participants = new ArrayList<>();
        participants.add("testUser1");
        participants.add("testUser2");
        participants.add("testUser3");
        participants.add("testUser4");

        List<String> results = new ArrayList<>();
        results.add("testResult1");
        results.add("testResult2");
        results.add("testResult3");
        results.add("testResult4");

        Ladder ladder = new Ladder(participants, results, layers);
        ladder.buildResultMap();

        // Act & Assert
        assertThat(ladder.getEveryResults()).isEqualTo(
                "testUser4: testResult3\n" +
                "testUser3: testResult1\n" +
                "testUser2: testResult2\n" +
                "testUser1: testResult4\n"
        );
    }
}
