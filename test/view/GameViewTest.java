package view;

import domain.LadderGame;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameViewTest {

    @Test
    void getNameList() {
        // given
        final int MAX_NAME_LENGTH = 5;
        String participantsInput = "jaden,R,james,joy,joo,huey";
        List<String> participants = Arrays.asList(participantsInput.split(","));
        GameView gameView = new GameView(new LadderGame(false));

        // when
        String nameList = gameView.getNameList(participants);

        // then
        // 먼저 전체 길이가 최대이름길이*참가자수+공백의개수 가 아니라면 실패
        assertEquals(nameList.length(), 35);
        // 실제 반환된 string의 내용이 기대한 값과 일치하지 않으면 실패
        assertEquals(nameList, "jaden   R   james  joy   joo  huey ");
    }

    @Test
    void getStandardizedName() {
        // given
        String participantName = "john";
        GameView gameView = new GameView(new LadderGame(false));

        // when
        String standardizedName = gameView.getStandardizedName(participantName);

        // then
        // 원하는 길이의 문자열로 잘 규격화 되었는지 체크
        assertEquals(standardizedName.length(), 5);
        // 길이가 잘 규격화 되었다면, 규격화 이 후 포함하고있는 이름 정보가 변조되지는 않았는지 체크
        assertEquals(standardizedName.trim(), participantName);
    }
}
