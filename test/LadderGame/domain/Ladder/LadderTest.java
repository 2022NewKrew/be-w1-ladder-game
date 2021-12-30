package LadderGame.domain.Ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Ladder 테스트")
class LadderTest {
    @Test
    @DisplayName("입력받은 높이의 사다리를 만든다.")
    public void 사다리_높이_테스트(){
        //given
        int ladderWidth = 4, ladderHeight = 3;

        //when
        List<Line> ladder = new Ladder(ladderWidth, ladderHeight).getLadder();

        //then
        assertEquals(ladder.size(), ladderHeight);
    }

    @Test
    @DisplayName("사다리의 높이는 1이상이어야 한다.")
    public void 사다리_높이_제한_테스트(){
        //given
        int ladderWidth = 4, ladderHeight = 0;

        //when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new Ladder(ladderWidth, ladderHeight));

        //then
        assertEquals(exception.getMessage(), "사다리 높이는 1 이상이어야 합니다.");
    }
}
