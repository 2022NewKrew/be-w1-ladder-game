package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;


public class LevelTest {

    static Level level;

    @BeforeEach
    void setUp() {
        int testNumPlayers = 5;
        level = new Level(testNumPlayers);
    }

    @Test
    void checkLineOverlap() {
        String levelString = level.toString();
        assertFalse(levelString.contains("|-----|-----|"));
    }

}
