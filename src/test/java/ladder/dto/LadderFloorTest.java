package ladder.dto;

import ladder.domain.LadderFloor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderFloorTest {

    @Test
    @DisplayName("참여자가 1명인 경우 LadderFloor 출력")
    public void 출력테스트_길이1() {
        // given
        List<Boolean> isConnected = new ArrayList<>();

        // when
        LadderFloor ladderFloor = new LadderFloor(isConnected);

        // then
        assertThat(ladderFloor.toString()).isEqualTo("|");
    }

    @Test
    @DisplayName("참여자가 4명인 경우 LadderFloor 출력 및 출력 형태 확인")
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