package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
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

    @Test
    @DisplayName("(생성자) 리스트가 비어있다면 에러가 발생한다.")
    void createWithEmptyList() {
        // given

        // when
        ThrowingCallable callable = () -> new Players(new ArrayList<>());

        // then
        assertThatThrownBy(callable).isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("(정적팩토리메서드) 배열이 비어있다면 에러가 발생한다.")
    void createWithEmptyArray() {
        // given

        // when
        ThrowingCallable callable = () -> Players.valueOf(new String[0]);

        // then
        assertThatThrownBy(callable).isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("이름으로 플레이어를 반환한다.")
    void getWithContains() {
        // given
        String name = "ato";
        Player player = new Player(name);
        Players players = new Players(new ArrayList<>(List.of(player)));

        // when
        Player value = players.get(name);

        // then
        assertThat(value).usingRecursiveComparison().isEqualTo(new Player(name));
    }

    @Test
    @DisplayName("이름으로 플레이어를 가져올때 존재하지 않는다면 에러가 발생한다.")
    void getWithNotContains() {
        // given
        Player player = new Player("ato");
        Players players = new Players(new ArrayList<>(List.of(player)));

        // when
        ThrowingCallable callable = () -> players.get("haha");

        // then
        assertThatThrownBy(callable).isExactlyInstanceOf(IllegalArgumentException.class);
    }
}
