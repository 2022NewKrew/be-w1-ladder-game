import domain.LadderPlayers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LadderPlayersTest {
    private final int MAX_PLAYER_NAME_LENGTH = 5;
    private LadderPlayers ladderPlayers;

    @BeforeEach
    public void setUp() {
        ArrayList<String> testPlayers = new ArrayList<>();
        testPlayers.add("a");
        testPlayers.add("bb");
        testPlayers.add("ccc");
        testPlayers.add("dddd");
        testPlayers.add("eeeee");
        ladderPlayers = new LadderPlayers(testPlayers);
    }

    @Test
    public void testStringBuilderLength() {
        StringBuilder playerStringBuilder = ladderPlayers.toStringBuilder(MAX_PLAYER_NAME_LENGTH);
        int expectedLength = (MAX_PLAYER_NAME_LENGTH + 1) * ladderPlayers.length() + 1; // \n
        assertEquals(expectedLength, playerStringBuilder.toString().length());
    }
}
