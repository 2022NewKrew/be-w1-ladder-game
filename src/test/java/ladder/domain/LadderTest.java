package ladder.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Ladder Test")
class LadderTest {

    static private Ladder ladder;

    @BeforeAll
    static void beforeAll() {
        ladder = new Ladder();
    }

    @DisplayName("하나의 라인에서 사다리가 연속해서 두 개 이상 존재하지 않는다.")
    @Test
    void 사다리_유효성_테스트() {
        //given
        int numOfPlayers = 100;
        int numOfLine = 100;

        //when
        ladder.setLadder(numOfPlayers, numOfLine);

        //then
        assertFalse(ladder.getLadder().stream() // Stream<LadderLine>
                .map(LadderTest::isValidate) // Stream<Boolean>
                .collect(Collectors.toList()) // List<Boolean>
                .contains(false));
    }

    static boolean isValidate(LadderLine line) {
        List<Boolean> points = line.getLine();
        for (int i = 1; i < points.size(); i++) {
            if (abnormalCondition(points.get(i - 1), points.get(i)))
                return false;
        }
        return true;
    }

    //prev point와 current point에 모두 bridge가 있다면 비정상 컨디션으로 분류
    static boolean abnormalCondition(boolean prev, boolean current) {
        return prev && current;
    }
}