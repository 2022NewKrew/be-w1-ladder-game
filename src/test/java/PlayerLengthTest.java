import Domain.Player;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class PlayerLengthTest {
    @Test
    void player_length_over() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Player("this_over_5_length");
        });
    }
}
