package domain;

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
        assertEquals(ladder.runToGoal(POBI), 0);
        assertEquals(ladder.runToGoal(HONUX), 3);
        assertEquals(ladder.runToGoal(CRONG), 2);
        assertEquals(ladder.runToGoal(JK), 1);
    }

}