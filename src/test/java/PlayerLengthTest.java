import Domain.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class PlayerLengthTest {
    @Test
    void player_length_over() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Player("this_over_5_length");
        });

    }
}
