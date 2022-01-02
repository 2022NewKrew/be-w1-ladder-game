import ladder.domain.Ladder;
import ladder.domain.Line;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LadderTest {

    @Test
    @DisplayName("Line 객체에서 선을 그릴 수 있는지 여부 판단하는 로직 테스트")
    public void HorizontalLineConnectionTest() {
        //given
        int playerNumber = 5;
        Line line = new Line(playerNumber);
        List<Boolean> consecutiveConnection = new ArrayList<>(); //연속해서 가로선이 있는지 확인하는 리스트

        //when
        for (int i = 1; i < playerNumber - 1; i++) {
            int columnIndex = i * 2 + 1;
            boolean isConnected = line.isConnected(columnIndex);
            boolean isLeftConnected = line.isLeftConnected(columnIndex);

            consecutiveConnection.add((isConnected && isLeftConnected)); //연속해서 가로선이 있으면 true, 그렇지 않으면 false
        }

        //then
        assertThat(consecutiveConnection).doesNotContain(true); //true 값이 있으면 test 실패
    }

    @Test
    @DisplayName("사다리 결과를 출력할 때 최대 5글자를 정확히 출력하는지 처리하는 로직 테스트")
    public void OutputTest() {
        //given
        List<String> playerNames = new ArrayList<>(Arrays.asList("abcdefg", "hij", "klm", "nop"));
        List<String> resultList = new ArrayList<>(Arrays.asList("3000", "꽝", "5000", "꽝"));
        int ladderHeight = 5;
        Ladder ld = new Ladder(playerNames, resultList, ladderHeight);

        //when
        StringBuilder sb = ld.playerListToString();

        //then
        assertThat(sb.toString()).isEqualTo(" abcde   hij   klm   nop");
    }
}
