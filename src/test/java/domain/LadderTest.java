package domain.value;

import common.value.LadderHeight;
import common.value.Player;
import common.value.PlayerCount;
import common.value.Players;
import domain.Ladder;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LadderTest {

    private static final int POBI = 0;
    private static final int HONUX = 1;
    private static final int CRONG = 2;
    private static final int JK = 3;

    @Test
    void test() {
        // TDD : run을 개발할 때, 테스트 코드를 먼저 설정한 후 개발했는데, 일급컬렉션안에 비지니스로직(행위)을 구현한 것이
        // 개발할 때 많은 도움이 되었습니다.
        // given
        Ladder ladder = new Ladder(new PlayerCount(4), new LadderHeight(5));

        // when
        ladder.makeHorizontalLine(POBI, 0);
        ladder.makeHorizontalLine(POBI, 2);
        ladder.makeHorizontalLine(POBI, 4);
        ladder.makeHorizontalLine(HONUX, 1);
        ladder.makeHorizontalLine(HONUX, 3);
        ladder.makeHorizontalLine(CRONG, 0);
        ladder.makeHorizontalLine(CRONG, 4);

        List<Player> playerList = new ArrayList<>();
        playerList.add(new Player("POBI"));
        playerList.add(new Player("HONUX"));
        playerList.add(new Player("CRONG"));
        playerList.add(new Player("JK"));
        Players players = new Players(playerList);

        // then
        // LadderBoardScreen ladderBoardScreen = new LadderBoardScreen();
        // LadderGameResult ladderGameResult = new LadderGameResult(players, ladder);
        // ladderBoardScreen.render(ladderGameResult);
        assertEquals(ladder.run(POBI), 0);
        assertEquals(ladder.run(HONUX), 3);
        assertEquals(ladder.run(CRONG), 2);
        assertEquals(ladder.run(JK), 1);
    }

}