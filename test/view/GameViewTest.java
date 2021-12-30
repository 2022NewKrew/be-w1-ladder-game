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
        GameView gameView = new GameView(new LadderGame());

        // when
        String nameList = gameView.getNameList(participants);

        // then
        // 먼저 전체 길이가 최대이름길이*참가자수+공백의개수 가 아니라면 실패
        assertEquals(nameList.length(), MAX_NAME_LENGTH * participants.size() + participants.size() - 1);
        // 이를 만족한다면, 최대이름길이 단위로 잘라 양쪽의 공백을 없앤 뒤, 참가자의 이름과 동일한지 테스트
        for (int i = 0; i < participants.size(); i++) {
            String nameFromNameList = nameList.substring(i * 6, i * 6 + 5).trim();
            assertEquals(nameFromNameList, participants.get(i));
        }
    }
}
