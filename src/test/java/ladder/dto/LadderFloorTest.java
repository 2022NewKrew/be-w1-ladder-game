package ladder.dto;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderFloorTest {

    @Test
    public void 출력테스트_길이1() {
        // given
        List<Boolean> isConnected = new ArrayList<>();

        // when
        LadderFloor ladderFloor = new LadderFloor(isConnected);

        // then
        assertThat(ladderFloor.toString()).isEqualTo("|");
    }

    @Test
    public void 출력테스트_길이10() {
        // given
        List<Boolean> isConnected = new ArrayList<>();
        isConnected.add(true);
        isConnected.add(false);
        isConnected.add(true);

        // when
        LadderFloor ladderFloor = new LadderFloor(isConnected);

        // then
        assertThat(ladderFloor.toString()).isEqualTo("|-----|     |-----|");
    }

}