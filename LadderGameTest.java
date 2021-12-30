import main.domain.LadderGame;
import main.domain.LadderGame.Line;
import org.junit.jupiter.api.*;
import java.util.ArrayList;
import static org.assertj.core.api.Assertions.*;

class LadderGameTest {
    @DisplayName("사다리 선 생성 테스트")
    @Test
    void lineCreateTest() {
        // Given
        String[] names = {"a", "b", "c", "d", "e"};
        int heightOfLadder = 5;
        LadderGame ladderGame = new LadderGame(names, heightOfLadder);
        ArrayList<Line> bridges = ladderGame.getBridges();

        // Then
        for(Line line : bridges) {
            ArrayList<Boolean> points = line.getPoints();
            for(int i = 1; i < points.size(); i ++) {
                assertThat(points.get(i-1) && points.get(i)).isFalse();
            }
        }
    }

    @DisplayName("초과된 크기의 이름 출력 테스트")
    @Test
    void longName_printTest() {
        // Given
        String[] names = {"aaaaaaaa", "bbbbbbbbbb", "cc", "ddddd"};
        int heightOfLadder = 5;
        LadderGame ladderGame = new LadderGame(names, heightOfLadder);

        // Then
        System.out.println("\nlongName_printTest");
        ladderGame.printLadder();
    }

    @DisplayName("1인 사다리 케이스 출력 테스트")
    @Test
    void onePerson_printTest() {
        // Given
        String[] names = {"abc"};
        int heightOfLadder = 10;
        LadderGame ladderGame = new LadderGame(names, heightOfLadder);

        // Then
        System.out.println("\nonPerson_printTest");
        ladderGame.printLadder();
    }

}
