import ladder.domain.Line;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
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
}
