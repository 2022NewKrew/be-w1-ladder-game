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
        List<String> result = Arrays.asList("5000", "0", "3000", "0", "10000");
        ladder = new Ladder(testLadderHeight, testPlayerList, result);
    }

    @Test
    void testPlayerNamePrint() {
        assertTrue(outStream.toString().startsWith("사다리 결과\nalpha  beta charl delta  echo "));
    }

}
