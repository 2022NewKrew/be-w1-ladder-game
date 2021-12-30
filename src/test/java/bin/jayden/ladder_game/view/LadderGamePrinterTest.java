package bin.jayden.ladder_game.view;

import bin.jayden.ladder_game.domain.Ladder;
import bin.jayden.ladder_game.domain.LadderGameInfo;
import bin.jayden.ladder_game.exception.InvalidParticipantException;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LadderGamePrinterTest {

    @Test
    void getAllResultsTest() {
        //given
        String[] participants = {"one", "two"};
        String[] result = {"1000", "2000"};
        int height = 5;
        int width = participants.length;
        Ladder ladder = new Ladder(width, height);
        LadderGameInfo info = assertDoesNotThrow(() -> new LadderGameInfo(participants, result, height));
        Map<String, String> resultsMap = new HashMap<>();
        resultsMap.put("one", "1000");
        resultsMap.put("two", "2000");

        //when
        LadderGamePrinter ladderGamePrinter = new LadderGamePrinter(ladder, info, resultsMap);
        String allResults = ladderGamePrinter.getAllResults();

        //then
        assertThat(allResults).isEqualTo("\n실행 결과\none : 1000\ntwo : 2000");
    }

    @Test
    void getOneResultTest() {
        //given
        String[] participants = {"one", "two"};
        String[] result = {"1000", "2000"};
        int height = 5;
        int width = participants.length;
        Ladder ladder = new Ladder(width, height);
        LadderGameInfo info = assertDoesNotThrow(() -> new LadderGameInfo(participants, result, height));
        Map<String, String> resultsMap = new HashMap<>();
        resultsMap.put("one", "1000");
        resultsMap.put("two", "2000");
        LadderGamePrinter ladderGamePrinter = new LadderGamePrinter(ladder, info, resultsMap);

        //when
        String oneResult = assertDoesNotThrow(() -> ladderGamePrinter.getOneResult("one"));

        //then
        assertThat(oneResult).isEqualTo("\n실행 결과\n1000");
    }

    @Test
    void getOneResultWrongNameTest() {
        //given
        String[] participants = {"one", "two"};
        String[] result = {"1000", "2000"};
        int height = 5;
        int width = participants.length;
        Ladder ladder = new Ladder(width, height);
        LadderGameInfo info = assertDoesNotThrow(() -> new LadderGameInfo(participants, result, height));
        Map<String, String> resultsMap = new HashMap<>();
        resultsMap.put("one", "1000");
        resultsMap.put("two", "2000");
        LadderGamePrinter ladderGamePrinter = new LadderGamePrinter(ladder, info, resultsMap);

        //when
        final InvalidParticipantException exception = assertThrows(InvalidParticipantException.class, () -> ladderGamePrinter.getOneResult("wrong"));

        //then
        assertThat(exception.getMessage()).isEqualTo("존재하지 않는 사용자");

    }

}