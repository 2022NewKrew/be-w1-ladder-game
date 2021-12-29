package ladderGame.view.input;

import ladderGame.domain.ladderConfig.LadderConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class HeightAndNumOfPeopleInputInterfaceTest {

    @Test
    @DisplayName("정상적인 입력에 대해서 성공적으로 LadderConfig를 반환하는 테스트")
    void inputLadderConfig() {
        // given
        final Integer numOfPeople = 3;
        final Integer height = 5;

        final String inputStr = numOfPeople + "\n" + height;

        final InputStream in = new ByteArrayInputStream(inputStr.getBytes());
        System.setIn(in);

        final InputInterface heightAndNumOfPeopleInputInterface = new HeightAndNumOfPeopleInputInterface();

        //when
        LadderConfig ladderConfig = heightAndNumOfPeopleInputInterface.inputLadderConfig();

        //then
        assertEquals(height, ladderConfig.getHeight());
        assertEquals(numOfPeople, ladderConfig.getNumOfPeople());
    }
}