package domain;

import common.value.LadderHeight;
import common.value.PlayerCount;
import domain.value.Ladder;
import domain.value.VerticalLine;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class LadderRandomGeneratorTest {

    @DisplayName("사다리 라인에서 선을 생성할 수 있는지 확인하는 로직을 테스트 한다.")
    @Test
    void VerticalLine에서_선을_생성하는_여부_확인_테스트() {

        // given
        Ladder ladder = new Ladder(new PlayerCount(3), new LadderHeight(2));

        // when
        ladder.makeHorizontalLine(0, 0);
        ladder.makeHorizontalLine(1, 1);

        // then
        VerticalLine playerZeroVerticalLine = ladder.getVerticalLine(0);
        VerticalLine playerOneVerticalLine = ladder.getVerticalLine(1);
        VerticalLine playerTwoVerticalLine = ladder.getVerticalLine(2);

        assertFalse(playerOneVerticalLine.isConnectableTo(playerTwoVerticalLine, 0));
        assertFalse(playerZeroVerticalLine.isConnectableTo(playerOneVerticalLine, 1));
    }

}