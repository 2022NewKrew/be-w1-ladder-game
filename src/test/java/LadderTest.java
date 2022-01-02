package test.java;

import main.java.domain.LadderGenerator;
import main.java.domain.LineGenerator;
import main.java.domain.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LadderTest {
    @Test
    public void Ladder_높이_Test(){
        LadderGenerator ladderGenerator = new LadderGenerator();
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> ladderGenerator.generateLadder(3,0));
        assertEquals("사다리 높이는 1이상이어야 합니다.",illegalArgumentException.getMessage());
    }
}
