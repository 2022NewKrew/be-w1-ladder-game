package domain;

import common.value.LadderHeight;
import common.value.PlayerCount;
import domain.value.VerticalLine;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LadderRandomGeneratorTest {

    private static final int PLAYER_0 = 0;
    private static final int PLAYER_1 = 1;
    private static final int PLAYER_2 = 2;
    private static final int PLAYER_3 = 3;

    @DisplayName("사다리 라인에서 선을 생성할 수 있는지 확인하는 로직을 테스트 한다.")
    @Test
    void VerticalLine에서_선을_생성하는_여부_확인_테스트() {

        // given
        Ladder ladder = new Ladder(new PlayerCount(4), new LadderHeight(2));

        // when
        ladder.makeHorizontalLine(PLAYER_0, 0);
        ladder.makeHorizontalLine(PLAYER_1, 1);

        // then
        VerticalLine playerZeroVerticalLine = ladder.getVerticalLine(PLAYER_0);
        VerticalLine playerOneVerticalLine = ladder.getVerticalLine(PLAYER_1);
        VerticalLine playerTwoVerticalLine = ladder.getVerticalLine(PLAYER_2);
        VerticalLine playerThreeVerticalLine = ladder.getVerticalLine(PLAYER_3);

        assertFalse(playerOneVerticalLine.isConnectableTo(playerTwoVerticalLine, 0));
        assertFalse(playerZeroVerticalLine.isConnectableTo(playerOneVerticalLine, 1));
        assertTrue(playerTwoVerticalLine.isConnectableTo(playerThreeVerticalLine, 0));
    }

}