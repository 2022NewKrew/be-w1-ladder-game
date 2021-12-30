package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

public class LayerTest {

    @Test
    void proceed_Invoked_ActsCorrectly(){
        List<Boolean> horizontalLines = new ArrayList<>();
        horizontalLines.add(true);
        horizontalLines.add(false);
        horizontalLines.add(true);

        Layer layer = new Layer(horizontalLines);

        List<Integer> participantIndices = new ArrayList<>();
        participantIndices.add(1);
        participantIndices.add(2);
        participantIndices.add(3);
        participantIndices.add(4);

        layer.proceed(participantIndices);

        assertThat(participantIndices.get(0)).isEqualTo(2);
        assertThat(participantIndices.get(1)).isEqualTo(1);
        assertThat(participantIndices.get(2)).isEqualTo(4);
        assertThat(participantIndices.get(3)).isEqualTo(3);
    }
}
