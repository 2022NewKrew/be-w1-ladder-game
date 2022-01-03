package laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FlagFactoryTest {

    @Test
    @DisplayName("previous flag가 true인 경우 Flag 객체 생성 확인")
    void create() {
        Boolean previous = true;
        Flag flag = FlagFactory.create(previous);
        assertThat(flag.getFlag()).isEqualTo(false);
    }
}