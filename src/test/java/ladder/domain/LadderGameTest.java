package ladder.domain;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LadderGameTest {
    private LadderGame game;

    private static InputStream stdin;

    @BeforeAll
    static void setUp() {
        stdin = System.in;
    }

    @AfterAll
    static void teardown() {
        System.setIn(stdin);
    }

    @Test
    void generateLadder() {
        // given
        String newline = System.lineSeparator();
        List<String> players = Arrays.asList("aaa", "bb", "ccccc");
        String playersInput = String.join(",", players);
        final int height = 5;
        String buf = String.join(newline, playersInput, String.valueOf(height));
        System.setIn(new ByteArrayInputStream(buf.getBytes()));

        // when
        game = new LadderGame();

        // then
        assertThat(game.getPlayers().size()).isEqualTo(players.size());
        assertThat(game.getLadder().getRows().size()).isEqualTo(height);
    }
}