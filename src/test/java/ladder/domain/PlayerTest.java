package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

class PlayerTest {

    @Test
    @DisplayName("Player를 생성한다.")
    void create() {
        // given
        String name = "ato";

        // when
        Player player = new Player(name);

        // then
        assertThat(player.getName()).isEqualTo(name);
    }


    @ParameterizedTest
    @NullSource
    @ValueSource(strings = "")
    @DisplayName("이름이 없다면 에러가 발생한다.")
    void createWithEmptyName(String name) {
        // given

        // when
        ThrowingCallable callable = () -> new Player(name);

        // then
        assertThatThrownBy(callable).isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"mungto", "test12345"})
    @DisplayName("5글자 이상이면 에러가 발생한다.")
    void createWithMaxNameLengthOver(String name) {
        // given

        // when
        ThrowingCallable callable = () -> new Player(name);

        // then
        assertThatThrownBy(callable).isExactlyInstanceOf(IllegalArgumentException.class);
    }
}
