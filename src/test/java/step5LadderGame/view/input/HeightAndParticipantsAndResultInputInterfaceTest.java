package step5LadderGame.view.input;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2LadderGame.domain.ladderConfig.LadderConfig;
import step2LadderGame.view.input.InputInterface;
import step5LadderGame.domain.ladderConfig.LadderIncludeParticipantsAndResultsConfig;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

class HeightAndParticipantsAndResultInputInterfaceTest {

    @Test
    @DisplayName("정상적인 입력에 대해서 LadderIncludeParticipantsAndResultsConfig를 성공적으로 반환하는 테스트")
    void inputLadderConfig() {
        // given
        final List<String> participants = List.of("aaaaa", "bbbb", "ccc", "dd", "e");
        final List<String> results = List.of("1", "2", "3", "4", "5");

        final Integer height = 5;
        final String inputStr = String.join(",", participants) + "\n" + height;

        final InputStream in = new ByteArrayInputStream(inputStr.getBytes());
        System.setIn(in);

        final InputInterface inputInterface = new HeightAndParticipantsAndResultInputInterface();

        //when
        final LadderConfig ladderConfig = inputInterface.inputLadderConfig();

        //then
        assertEquals(LadderIncludeParticipantsAndResultsConfig.class, ladderConfig.getClass());
        assertEquals(height, ladderConfig.getHeight());

        List<String> actualParticipants = ((LadderIncludeParticipantsAndResultsConfig) ladderConfig).getParticipants();
        assertIterableEquals(participants, actualParticipants);

        List<String> actualResults = ((LadderIncludeParticipantsAndResultsConfig) ladderConfig).getResults();
        assertIterableEquals(results, actualResults);
    }
}