package service;

import domain.ladder.Ladder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class LadderServiceTest {

    @Test
    @DisplayName("게임을 위한 사다리 생성 테스트")
    void gameLadderTest() {
        //given
        List<Boolean> testLine = Arrays.asList(false, true);
        int participantNumber = 3;
        Ladder ladder = new Ladder(participantNumber, 2, (column) -> testLine);
        List<List<Boolean>> expected = Arrays.asList(
                Arrays.asList(true, false, true, false, true),
                Arrays.asList(true, false, true, true, true),
                Arrays.asList(true, false, true, true, true),
                Arrays.asList(true, false, true, false, true)
        );

        //when
        LadderService ladderService = new LadderService(ladder);
        List<List<Boolean>> result = ladderService.createLadderForGame(participantNumber);

        //then
        for(int i = 0; i < expected.size(); i++) {
            for(int j = 0; j < expected.get(0).size(); j++) {
                Assertions.assertEquals(expected.get(i).get(j), result.get(i).get(j));
            }
        }
    }
}
