package laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PlayerTest {

    @DisplayName("Player 생성 테스트")
    @Test
    void from() {
        String name = "aaaaa";

        Player player = Player.from(name);

        assertThat(player.getName()).isEqualTo(name);
    }
}