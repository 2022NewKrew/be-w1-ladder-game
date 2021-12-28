package ladder.domain;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayersTest {

    @Test
    @DisplayName("배열로 players를 생성한다.")
    void valueOf() {
        // given
        String[] names = {"ato", "sun", "vince", "trevi", "root", "cold"};

        // when
        Players players = Players.valueOf(names);

        // then
        assertThat(players.getPlayers()).hasSize(names.length);
    }
}
