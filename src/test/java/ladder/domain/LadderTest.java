package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

class LadderTest {

    Ladder ladder;

    @Test
    void setLadder() {
        int numOfPlayers = 100;
        int numOfLine = 100;

        ladder = new Ladder();
        ladder.setLadder(numOfPlayers, numOfLine);

        List<LadderLine> lines = ladder.getLadder();
    }

    @Test
    void getLadder() {
    }
}