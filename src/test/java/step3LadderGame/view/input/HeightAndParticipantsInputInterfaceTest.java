package step3LadderGame.view.input;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2LadderGame.domain.ladderConfig.LadderConfig;
import step2LadderGame.view.input.InputInterface;
import step3LadderGame.domain.ladderConfig.LadderIncludeParticipantsConfig;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

class HeightAndParticipantsInputInterfaceTest {

    @Test
    @DisplayName("정상적인 입력에 대해서 성공적으로 LadderIncludeNamesConfig를 반환하는 테스트")
    void inputLadderConfig() {
        // given
        final List<String> participants = List.of("aaaaa", "bbbb", "ccc", "dd", "e");
        final Integer height = 5;
        final String inputStr = String.join(",", participants) + "\n" + height;

        final InputStream in = new ByteArrayInputStream(inputStr.getBytes());
        System.setIn(in);

        final InputInterface heightAndPeopleNamesInputInterface = new HeightAndParticipantsInputInterface();

        //when
        final LadderConfig ladderConfig = heightAndPeopleNamesInputInterface.inputLadderConfig();

        //then
        assertEquals(LadderIncludeParticipantsConfig.class, ladderConfig.getClass());
        assertEquals(height, ladderConfig.getHeight());

        List<String> actualParticipants = ((LadderIncludeParticipantsConfig) ladderConfig).getParticipants();
        assertIterableEquals(participants, actualParticipants);
    }
}