import ladder.LadderGameService;
import ladder.domain.Bridge;
import ladder.domain.Ladder;
import ladder.domain.Line;
import ladder.exception.NameLengthException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class LadderGameServiceTest {
    LadderGameService ladderGameService;

    @BeforeEach
    public void initialize() {
        ladderGameService = new LadderGameService();
    }

    /**
     * 사람들의 이름이 잘 들어가는지 확인
     */
    @Test
    public void inputNameLengthTest() {
        //given
        List<String> nameList = Arrays.asList("a", "ab", "abc", "abcde");

        //when
        //ladderGameService.makePlayers(nameList);
        //List<String> playersName = ladderGameService.getPlayersName();

        //then
        //Assertions.assertArrayEquals(nameList.toArray(), playersName.toArray());
    }

    /**
     * 플레이어 이름이 5글자 넘었을 경우 테스트
     */
    @Test
    public void exceedNameLengthTest() {
        //given
        List<String> nameList = Arrays.asList("a", "abfafagab", "abc", "abcafade");

        //when
        NameLengthException thrown = Assertions.assertThrows(NameLengthException.class, () -> {
            //ladderGameService.makePlayers(nameList);
        });

        //then
        Assertions.assertEquals("플레이어의 이름은 5글자 미만으로 입력하시오.", thrown.getMessage());
    }

    /**
     * 브릿지가 그려지는지 테스트
     */
    @Test
    public void drawBridgeSuccessTest() {
        //given
        //ladderGameService.makePlayers(Arrays.asList("a", "ab", "abc", "abcde"));
        //ladderGameService.makeLadder(5);

        //when
        //ladderGameService.drawBridge(2, 3);
        //Ladder ladder = ladderGameService.getLadder();
        //Line line = ladder.getOneLine(2);
        //Bridge bridge = line.getOneBridge(3);

        //then
        //Assertions.assertEquals(true, bridge.isExist());
    }

    /**
     * 브릿지가 그려지지 않는 경우 테스트
     * case1 : 사다리의 가장자리가 아닌 경우
     */
    @Test
    public void drawBridgeFailTest1() {
        /*
        //given
        ladderGameService.makePlayers(Arrays.asList("a", "ab", "abc", "abcde"));
        ladderGameService.makeLadder(5);

        //when
        ladderGameService.drawBridge(1, 3);
        ladderGameService.drawBridge(2, 3);
        Ladder ladder = ladderGameService.getLadder();

        Line line = ladder.getOneLine(2);
        Bridge bridge = line.getOneBridge(3);

        //then
        Assertions.assertEquals(false, bridge.isExist());
         */
    }

    /**
     * 브릿지가 그려지지 않는 경우 테스트
     * case2 : 사다리의 왼쪽 가장자리
     */
    @Test
    public void drawBridgeFailTest2() {
        /*
        //given
        ladderGameService.makePlayers(Arrays.asList("a", "ab", "abc", "abcde"));
        ladderGameService.makeLadder(5);

        //when
        ladderGameService.drawBridge(1, 3);
        ladderGameService.drawBridge(0, 3);
        Ladder ladder = ladderGameService.getLadder();

        Line line = ladder.getOneLine(0);
        Bridge bridge = line.getOneBridge(3);

        //then
        Assertions.assertEquals(false, bridge.isExist());
         */
    }

    /**
     * 브릿지가 그려지지 않는 경우 테스트
     * case3 : 사다리의 오른쪽 가장자리
     */
    @Test
    public void drawBridgeFailTest3() {
        /*
        //given
        ladderGameService.makePlayers(Arrays.asList("a", "ab", "abc", "abcde"));
        ladderGameService.makeLadder(5);

        //when
        ladderGameService.drawBridge(2, 3);
        ladderGameService.drawBridge(3, 3);
        Ladder ladder = ladderGameService.getLadder();

        Line line = ladder.getOneLine(3);
        Bridge bridge = line.getOneBridge(3);

        //then
        Assertions.assertEquals(false, bridge.isExist());

         */
    }
}
