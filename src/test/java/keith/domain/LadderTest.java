package keith.domain;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class LadderTest {
    static Ladder ladder;

    @Test
    void getConnectionsTest() {
        List<String> names = new ArrayList<>();
        for (int i = 0; i <= 100; i++) {
            names.add("test");
            ladder = new Ladder(names,i);
            assertThat(ladder.getConnections().size()).isEqualTo(i);
        }
    }

    @Test
    void getParticipantsTest() {
        List<String> names = new ArrayList<>();
        ladder = new Ladder(names, 5);
        assertThat(ladder.getParticipants().size()).isEqualTo(0);
        for (int i = 1; i <= 100; i++) {
            names.add("test");
            ladder = new Ladder(names,5);
            assertThat(ladder.getParticipants().size()).isEqualTo(i);
        }
    }
}
