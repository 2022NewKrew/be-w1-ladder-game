package test.java;

import main.java.domain.Players;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PlayersTest {
    @Test
    public void Players_참여자수_Test(){
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> new Players(new String[]{"pobi"}));
        assertEquals("참여자는 2명 이상이어야 합니다.",illegalArgumentException.getMessage());
    }
}
