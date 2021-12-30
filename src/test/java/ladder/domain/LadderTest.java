package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

public class LadderTest {

    static Ladder ladder;
    private final ByteArrayOutputStream outStream = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outStream));
        List<String> testPlayerList = Arrays.asList("alpha", "beta", "charlie", "delta", "echo");
        int testLadderHeight = 7;
        ladder = new Ladder(testLadderHeight, testPlayerList);
    }

    @Test
    void testPlayerNamePrint() {
        ladder.printLadder();
        assertTrue(outStream.toString().startsWith("alpha  beta charl delta  echo "));
    }

}
