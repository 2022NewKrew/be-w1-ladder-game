package service;

import domain.Result;
import domain.ladder.Ladder;
import domain.participant.Participant;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class LadderGameServiceTest {

    @Test
    @DisplayName("게임이 제대로 결과를 내는지 확인하는 테스트")
    void playGameTest() {
        List<Boolean> testLine = Arrays.asList(false, true);
        int participantNumber = 3;
        Ladder ladder = new Ladder(participantNumber, 2, (column) -> testLine);
        LadderService ladderService = new LadderService(ladder);
        Participant participant = new Participant(Arrays.asList("ai", "bi", "ci"));
        ParticipantService participantService = new ParticipantService(participant);

        LadderGameService service = new LadderGameService(ladderService, participantService);

        Result result = new Result(Arrays.asList("5000", "4000", "3000"));

        Map<String, String> gameResult = service.playGame(result);

        Assertions.assertEquals("5000", gameResult.get("ai"));
        Assertions.assertEquals("4000", gameResult.get("bi"));
        Assertions.assertEquals("3000", gameResult.get("ci"));
    }
}
