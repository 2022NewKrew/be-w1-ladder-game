package step2LadderGame.view.input;

import step2LadderGame.domain.ladderConfig.LadderConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2LadderGame.view.input.HeightAndNumOfParticipantsInputInterface;
import step2LadderGame.view.input.InputInterface;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class HeightAndNumOfParticipantsInputInterfaceTest {

    @Test
    @DisplayName("정상적인 입력에 대해서 성공적으로 LadderConfig를 반환하는 테스트")
    void inputLadderConfig() {
        // given
        final Integer numOfPeople = 3;
        final Integer height = 5;

        final String inputStr = numOfPeople + "\n" + height;

        final InputStream in = new ByteArrayInputStream(inputStr.getBytes());
        System.setIn(in);

        final InputInterface heightAndNumOfPeopleInputInterface = new HeightAndNumOfParticipantsInputInterface();

        //when
        LadderConfig ladderConfig = heightAndNumOfPeopleInputInterface.inputLadderConfig();

        //then
        assertEquals(height, ladderConfig.getHeight());
        assertEquals(numOfPeople, ladderConfig.getNumOfParticipants());
    }
}